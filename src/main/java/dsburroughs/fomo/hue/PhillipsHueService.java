package dsburroughs.fomo.hue;

import com.philips.lighting.hue.sdk.utilities.impl.PHHueHelper;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by shanu on 10/15/2017.
 */
@Service
public class PhillipsHueService {

    private static final Logger logger = LoggerFactory.getLogger(PhillipsHueFomoOutputService.class);
    private static final Random rand = new Random();

    @Autowired
    private PHBridge bridge;

    public void randomLight(){
        int hue = rand.nextInt(65535);

        final PHBridgeResourcesCache cache = bridge.getResourceCache();
        final List<PHLight> allLights = cache.getAllLights();
        for (PHLight light : allLights) {
            final PHLightState lightState = light.getLastKnownLightState();
            lightState.setOn(true);
            lightState.setHue(hue);
            logger.info("Updating Lights: {}", hue);
            bridge.updateLightState(light, lightState);
        }
    }
}
