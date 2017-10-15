package dsburroughs.fomo.hue;

import com.philips.lighting.hue.sdk.PHBridgeSearchManager;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sburroughs on 10/12/2017.
 */
@Configuration
@ConditionalOnProperty("hue.enabled")
public class HueConfig {

    @Value("hue.bridge.ipaddress")
    private String IP_ADDRESS;

    @Bean
    public PHHueSDK getHueSdk() {
        PHHueSDK sdk = PHHueSDK.getInstance();
        PHBridgeSearchManager sm = (PHBridgeSearchManager) sdk.getSDKService(PHHueSDK.SEARCH_BRIDGE);
        sm.setPortalAddress(IP_ADDRESS);
        sm.ipAddressSearch();
        return sdk;
    }

    @Bean
    public PHBridge getHueBridge(PHHueSDK sdk) throws InterruptedException {

        Object lock = new Object();

        PHSDKListener listener = new FomoHueListener(sdk, lock);
        sdk.getNotificationManager().registerSDKListener(listener);

        synchronized (lock) {
            lock.wait();
        }

        return sdk.getSelectedBridge();
    }

}
