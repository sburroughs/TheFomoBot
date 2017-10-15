package dsburroughs.fomo.discord;

import dsburroughs.fomo.service.FomoInputService;
import dsburroughs.fomo.web.FomoLevel;
import net.dv8tion.jda.core.JDA;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sburroughs on 10/7/2017.
 */
@Service
@ConditionalOnProperty("discord.enabled")
public class DiscordInputService implements FomoInputService {

    private static final Logger logger = LoggerFactory.getLogger(DiscordInputService.class);
    private static final Set<String> BLACKLIST = Stream.of("AFK").collect(Collectors.toCollection(HashSet::new));
    private static final Map<String, Integer> cache = new HashMap<>();

    @Autowired
    private JDA jda;

    @Override
    public FomoLevel getLevel() {

        cacheChannelCounts();
        int maxCount = getCacheMax();

        if (maxCount == 1) {
            return FomoLevel.LOW;
        } else if (maxCount == 2) {
            return FomoLevel.MEDIUM;
        } else if (maxCount == 3) {
            return FomoLevel.HIGH;
        } else if (maxCount == 4) {
            return FomoLevel.ULTRA;
        } else if (maxCount >= 5) {
            return FomoLevel.MAX;
        }

        return FomoLevel.NONE;

    }

    private int getCacheMax() {
        int maxCount = cache.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue).orElse(0);
        return maxCount;
    }

    private void cacheChannelCounts() {
        logger.info("Retrieving latest channel updates");
        jda.getGuilds().stream()
                .map(Guild::getVoiceChannels)
                .flatMap(List::stream)
                .filter(this::filterChannels)
                .forEach(this::cacheChannelCount);
        logger.info("Channel updates completed");
    }

    private boolean filterChannels(VoiceChannel channel) {
        return !BLACKLIST.contains(channel.getName());
    }

    private void cacheChannelCount(VoiceChannel channel) {
        final String key = channel.getName();
        final int count = channel.getMembers().size();
        logger.info("Caching Channel:{}:{}", key, count);
        cache.put(key, count);
    }

    @PreDestroy
    public void shutdownJda() {
        logger.info("shutting down jda");
        jda.shutdown();
    }

}
