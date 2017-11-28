package dsburroughs.fomo;

import dsburroughs.common.service.FomoLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shanu on 11/20/2017.
 */
public class LoggingOutputService implements FomoOutputService{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingOutputService.class);

    @Override
    public void output(FomoLevel fomoLevel) {
        LOGGER.info("OUTPUT: {}", fomoLevel.name());
    }
}
