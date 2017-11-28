package dsburroughs.fomo.tplink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sburroughs on 10/14/2017.
 */
@RestController
@ConditionalOnProperty("tplink.enabled")
public class TPLinkController {

    @Autowired
    private TPLinkService tpLinkService;

    @Value("${tplink.cloudUserName}")
    private String username;
    @Value("${tplink.cloudPassword}")
    private String password;

    @RequestMapping("/tplink")
    private String tplink() {

        final String token = tpLinkService.authenticate(username, password);
        final List<String> devices = tpLinkService.getDevices(token);
        final String deviceId = devices.get(0);
        tpLinkService.setSwitch(token, deviceId, true);
        return "FUCK YEAH. dem tp boys";

    }
}
