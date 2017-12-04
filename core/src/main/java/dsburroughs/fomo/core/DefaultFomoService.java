package dsburroughs.fomo.core;

import dsburroughs.fomo.common.service.FomoLevel;
import dsburroughs.fomo.FomoOutputService;
import dsburroughs.fomo.input.FomoInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Sburroughs on 10/14/2017.
 */
@Service
public class DefaultFomoService implements FomoProcessingService {

    private final Logger logger = LoggerFactory.getLogger(DefaultFomoService.class);
    private final FomoLevel DEFAULT_FOMO_LEVEL = FomoLevel.HIGH;

    private final FomoInputService inputService;
    private final FomoOutputService outputService;

    public DefaultFomoService(final FomoInputService inputService,
                              final FomoOutputService outputService) {
        this.inputService = inputService;
        this.outputService = outputService;
    }

    @Override
    public void process() {

        logger.debug("Retrieving Level");
        final FomoLevel level = inputService.getLevel();
        logger.debug("Level retrieved: {}", level.name());

        logger.debug("Outputting Level: {}", level.name());
        outputService.output(level);
        logger.debug("Outputting Level Complete");
    }

    public FomoInputService getInputService(){
        return this.inputService;
    }

    public FomoOutputService getOutputService(){
        return this.outputService;
    }
}
