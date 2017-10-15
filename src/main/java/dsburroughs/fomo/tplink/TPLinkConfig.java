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




}
