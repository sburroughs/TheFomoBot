package dsburroughs.fomo.hue;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by Sburroughs on 10/13/2017.
 */
public class FomoHueListener implements PHSDKListener {

    private static final Logger logger = LoggerFactory.getLogger(FomoHueListener.class);
    private final PHHueSDK sdk;
    private final Object lock;

    public FomoHueListener(PHHueSDK sdk, Object lock) {
        this.sdk = sdk;
        this.lock = lock;

    }

    @Override
    public void onAccessPointsFound(List<PHAccessPoint> accessPointsList) {
        logger.info("Found Access Point");
        sdk.connect(accessPointsList.get(0));
        accessPointsList.forEach(d -> System.out.println(d.getIpAddress() + " " + d.getMacAddress()));

    }

    @Override
    public void onAuthenticationRequired(PHAccessPoint accessPoint) {
        logger.info("Waiting for authentication");
        sdk.startPushlinkAuthentication(accessPoint);
    }

    @Override
    public void onBridgeConnected(PHBridge bridge, String username) {
        logger.info("Bridge ");

        sdk.setSelectedBridge(bridge);
        lock.notify();
        logger.info("Bridge Connected");
    }

    @Override
    public void onCacheUpdated(List<Integer> arg0, PHBridge arg1) {

    }

    @Override
    public void onConnectionLost(PHAccessPoint arg0) {
        logger.info("Connection Lost");
    }

    @Override
    public void onConnectionResumed(PHBridge arg0) {
        logger.info("Connection Resumed");
    }

    @Override
    public void onError(int code, final String message) {
        logger.info("Error:" + code + ":" + message);
    }

    @Override
    public void onParsingErrors(List<PHHueParsingError> parsingErrorsList) {
        for (PHHueParsingError parsingError : parsingErrorsList) {
            logger.info("ParsingError : " + parsingError.getMessage());
        }
    }

}
