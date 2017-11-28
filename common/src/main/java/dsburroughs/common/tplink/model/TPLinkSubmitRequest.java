package dsburroughs.common.tplink.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public abstract class TPLinkSubmitRequest {

    private final String method;
    private final Map<String, Object> params;

    public TPLinkSubmitRequest(final String deviceId, boolean isOn) {
        this.method = "passthrough";
        this.params = new HashMap();
        this.params.put("deviceId", deviceId);

        int state = 0;
        if (isOn) {
            state = 1;
        }

        final Map<String, Object> system = new HashMap<>();
        system.put("state", state);

        final Map<String, Object> setRelayState = new HashMap<>();
        setRelayState.put("set_relay_state", system);

        final Map<String, Object> requestData = new HashMap();
        requestData.put("system", setRelayState);





        this.params.put("requestData", requestData);
    }

    public String getMethod() {
        return method;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    private class TPLinkSystemRequest {

        private final Map<String, Object> system;

        public TPLinkSystemRequest(final int state) {
            this.system = new HashMap<>();
            this.system.put("state", state);

        }
    }

    @Override
    public String toString() {
        return "TPLinkSubmitRequest{" +
                "method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}

