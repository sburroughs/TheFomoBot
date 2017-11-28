package dsburroughs.fomo.tplink.model;

import java.util.Map;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkDeviceResponse {

    private final String method;
    private final Map<String, String> params;

    public TPLinkDeviceResponse(String method, Map<String, String> params) {
        this.method = method;
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getParams() {
        return params;
    }
}

