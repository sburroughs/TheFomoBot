package dsburroughs.fomo.hue;

import com.philips.lighting.model.*;
import dsburroughs.fomo.service.FomoOutputService;
import dsburroughs.fomo.web.FomoLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by Sburroughs on 10/12/2017.
 */
@Service
@ConditionalOnProperty("hue.enabled")
public class PhillipsHueFomoOutputService implements FomoOutputService {

    private static final Logger logger = LoggerFactory.getLogger(PhillipsHueFomoOutputService.class);
    private static final Random rand = new Random();

    @Autowired
    private PHBridge bridge;

    @Override
    public void output(FomoLevel fomoLevel) {

        logger.info("Output Received: {}", fomoLevel);

        if (fomoLevel.getLevel() > 0) {



        }
    }




}
