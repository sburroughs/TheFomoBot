package dsburroughs.fomo.hue;

import com.philips.lighting.hue.sdk.utilities.impl.Color;
import dsburroughs.fomo.common.hue.PhillipsHueService;
import dsburroughs.fomo.common.service.FomoLevel;
import dsburroughs.fomo.FomoOutputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * Created by Sburroughs on 10/12/2017.
 */
@Service
@ConditionalOnProperty("hue.enabled")
public class PhillipsHueOutputService implements FomoOutputService {

    private static final Logger logger = LoggerFactory.getLogger(PhillipsHueOutputService.class);

    @Autowired
    private PhillipsHueService service;

    @Override
    public void output(FomoLevel fomoLevel) {

        logger.info("Output Received: {}", fomoLevel);

        switch (fomoLevel) {
            case LOW:
                service.setLight(Color.GREEN);
                break;

            case MEDIUM:
                service.setLight(Color.YELLOW);
                break;

            case HIGH:
                service.setLight(Color.rgb(255, 165, 0));
                break;

            case ULTRA:
            case MAX:
                service.setLight(Color.RED);
                break;

            case NONE:
            default:
                service.setLight(Color.BLACK);
                break;
        }


    }


}
