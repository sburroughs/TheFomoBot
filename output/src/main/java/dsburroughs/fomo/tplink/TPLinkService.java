package dsburroughs.fomo.tplink;


import dsburroughs.common.service.FomoLevel;
import dsburroughs.fomo.FomoOutputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Sburroughs on 10/13/2017.
 */
@Service
@ConditionalOnProperty("tplink.enabled")
public class TPLinkService implements FomoOutputService {

    private static final Logger logger = LoggerFactory.getLogger(TPLinkService.class);
    private static final String AUTH_URL = "https://wap.tplinkcloud.com";
    private static final String TOKEN_URL = "https://wap.tplinkcloud.com?token={token}";
    private static final String PLUG_URL = "https://wap.tplinkcloud.com?token={token}";

    final RestTemplate restTemplate = new RestTemplate();


    @Override
    public void output(FomoLevel fomoLevel) {

    }

    public String authenticate(final String username, final String password) {

        final dsburroughs.common.tplink.model.TPLinkAuthRequest request = new dsburroughs.common.tplink.model.TPLinkAuthRequest(username, password);
        final ResponseEntity<dsburroughs.common.tplink.model.TPLinkAuthResponse> response = restTemplate.postForEntity(AUTH_URL, request, dsburroughs.common.tplink.model.TPLinkAuthResponse.class);
        final String body = response.getBody().getResult().get(0);
        logger.info(body);
        final String token = body;
        return token;
    }

    public List<String> getDevices(final String token) {
        final dsburroughs.common.tplink.model.TPLinkDeviceRequest request = new dsburroughs.common.tplink.model.TPLinkDeviceRequest();
        final ResponseEntity<String> response = restTemplate.postForEntity(TOKEN_URL, request, String.class, token);
        final String body = response.getBody();
        logger.info(body);
        return null;
    }


    public void setSwitch(final String token, final String deviceId, boolean isOn) {

        dsburroughs.common.tplink.model.TPLinkSubmitRequest request;
        if (isOn) {
            request = new dsburroughs.common.tplink.model.TPLinkOnRequest(deviceId);
        } else {
            request = new dsburroughs.common.tplink.model.TPLinkOffRequest(deviceId);
        }

        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PLUG_URL, request, String.class, token);
        logger.info(response.toString());

    }


}
