package dsburroughs.common.tplink;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sburroughs on 10/13/2017.
 */
@Configuration
@ConditionalOnProperty("tplink.enabled")
public class TPLinkConfig {




}
