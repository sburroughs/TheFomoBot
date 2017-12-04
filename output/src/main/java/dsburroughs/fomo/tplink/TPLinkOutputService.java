package dsburroughs.fomo.tplink;


import dsburroughs.fomo.common.service.FomoLevel;
import dsburroughs.fomo.FomoOutputService;
import dsburroughs.fomo.common.tplink.model.*;
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
public class TPLinkOutputService implements FomoOutputService {

    private static final Logger logger = LoggerFactory.getLogger(TPLinkOutputService.class);
    private static final String AUTH_URL = "https://wap.tplinkcloud.com";
    private static final String TOKEN_URL = "https://wap.tplinkcloud.com?token={token}";
    private static final String PLUG_URL = "https://wap.tplinkcloud.com?token={token}";

    final RestTemplate restTemplate = new RestTemplate();


    @Override
    public void output(FomoLevel fomoLevel) {

    }

    public String authenticate(final String username, final String password) {

        final TPLinkAuthRequest request = new TPLinkAuthRequest(username, password);
        final ResponseEntity<TPLinkAuthResponse> response = restTemplate.postForEntity(AUTH_URL, request, TPLinkAuthResponse.class);
        final String body = response.getBody().getResult().get(0);
        logger.info(body);
        final String token = body;
        return token;
    }

    public List<String> getDevices(final String token) {
        final TPLinkDeviceRequest request = new TPLinkDeviceRequest();
        final ResponseEntity<String> response = restTemplate.postForEntity(TOKEN_URL, request, String.class, token);
        final String body = response.getBody();
        logger.info(body);
        return null;
    }


    public void setSwitch(final String token, final String deviceId, boolean isOn) {

        TPLinkSubmitRequest request;
        if (isOn) {
            request = new TPLinkOnRequest(deviceId);
        } else {
            request = new TPLinkOffRequest(deviceId);
        }

        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PLUG_URL, request, String.class, token);
        logger.info(response.toString());

    }


}
