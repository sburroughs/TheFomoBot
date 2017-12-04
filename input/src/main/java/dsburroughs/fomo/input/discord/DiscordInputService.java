package dsburroughs.fomo.input.discord;

import dsburroughs.fomo.common.discord.DiscordService;
import dsburroughs.fomo.input.FomoInputService;
import dsburroughs.fomo.common.service.FomoLevel;
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

    @Autowired
    private DiscordService discordService;

    @Override
    public FomoLevel getLevel() {

        int maxCount = discordService.getMax();

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



}
