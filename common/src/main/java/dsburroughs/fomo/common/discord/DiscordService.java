package dsburroughs.fomo.common.discord;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shanu on 11/29/2017.
 */
@Service
public class DiscordService {

    private static final Logger logger = LoggerFactory.getLogger(DiscordService.class);
    private static final Set<String> BLACKLIST = Stream.of("AFK").collect(Collectors.toCollection(HashSet::new));
    private static final Map<String, Integer> cache = new HashMap<>();

    @Autowired
    private JDA jda;

    public int getMax() {

        cacheChannelCounts();

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
