package dsburroughs.fomo.common.tplink.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkAuthRequest {

    private final String method;
    private final Map<String, String> params;

    public TPLinkAuthRequest(final String username, final String password) {
        method = "login";
        params = new HashMap();
        params.put("appType", "Kasa_Android");
        params.put("cloudUserName", username);
        params.put("cloudPassword", password);
        params.put("terminalUUID", UUID.randomUUID().toString());

    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getParams() {
        return params;
    }
}

