package dsburroughs.fomo.tplink.model;

import java.util.Map;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkDeviceRequest {

    private final String method;

    public TPLinkDeviceRequest() {
        method = "getDeviceList";
    }

    public String getMethod() {
        return method;
    }

}

