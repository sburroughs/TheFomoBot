package dsburroughs.fomo.tplink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dsburroughs.fomo.service.FomoOutputService;
import dsburroughs.fomo.tplink.model.*;
import dsburroughs.fomo.web.FomoLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    private static final String TOKEN = "";

    @Autowired
    private TPLinkAuthRequest request;

    final RestTemplate restTemplate = new RestTemplate();


    @Override
    public void output(FomoLevel fomoLevel) {
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(AUTH_URL, request, String.class);
        logger.info(response.toString());
    }

    public void getDevices() {

        TPLinkDeviceRequest request = new TPLinkDeviceRequest();

        ResponseEntity<String> response = restTemplate.postForEntity(TOKEN_URL, request, String.class, TOKEN);
        logger.info(response.toString());

    }


    @Value("${tplink.deviceId}")
    private String deviceId;

    private boolean isOn = false;

    public void finaloutput() {

        TPLinkSubmitRequest request = new TPLinkOffRequest(deviceId);
        if (isOn) {
            request = new TPLinkOnRequest(deviceId);
        }
        isOn = !isOn;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String message = objectMapper.writeValueAsString(request);
            logger.info(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PLUG_URL, request, String.class, TOKEN);
        logger.info(response.toString());

    }

}
