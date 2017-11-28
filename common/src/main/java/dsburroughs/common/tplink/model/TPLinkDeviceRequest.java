package dsburroughs.common.tplink.model;


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

