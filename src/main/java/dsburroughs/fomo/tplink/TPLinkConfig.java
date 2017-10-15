package dsburroughs.fomo.tplink;

import dsburroughs.fomo.tplink.model.TPLinkAuthRequest;
import dsburroughs.fomo.tplink.model.TPLinkDeviceRequest;
import dsburroughs.fomo.tplink.model.TPLinkOnRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sburroughs on 10/13/2017.
 */
@Configuration
@ConditionalOnProperty("tplink.enabled")
public class TPLinkConfig {

    @Value("${tplink.cloudUserName}")
    private String username;
    @Value("${tplink.cloudPassword}")
    private String password;
    @Value("${tplink.deviceId}")
    private String deviceId;

    @Bean
    public TPLinkAuthRequest getTPLinkAuthRequest() {
        return new TPLinkAuthRequest(username, password);
    }

    @Bean
    public TPLinkDeviceRequest getTPLinkDeviceRequest() {
        return new TPLinkDeviceRequest();
    }

    @Bean
    public TPLinkOnRequest getTPLinkSubmitRequest() {
        return new TPLinkOnRequest(deviceId);
    }

}
