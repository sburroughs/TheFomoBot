package dsburroughs.fomo.service;

import dsburroughs.fomo.discord.DiscordInputService;
import dsburroughs.fomo.hue.FomoHueListener;
import dsburroughs.fomo.web.FomoLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Sburroughs on 10/14/2017.
 */
@Service
public class LoggingDefaultFomoService implements FomoInputService, FomoOutputService, FomoLevelProcessor {

    private final Logger logger = LoggerFactory.getLogger(LoggingDefaultFomoService.class);
    private final FomoLevel DEFAULT_FOMO_LEVEL = FomoLevel.HIGH;

    @Override
    public FomoLevel getLevel() {
        logger.info("DEFAULT LOGGING ONLY: getLevel{}", DEFAULT_FOMO_LEVEL);
        return DEFAULT_FOMO_LEVEL;
    }

    @Override
    public void output(FomoLevel fomoLevel) {
        logger.info("DEFAULT LOGGING ONLY: output {}", fomoLevel);
    }

    @Override
    public void process() {
        logger.info("DEFAULT LOGGING ONLY: process");
    }
}
