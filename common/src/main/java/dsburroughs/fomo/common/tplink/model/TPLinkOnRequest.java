package dsburroughs.fomo.common.tplink.model;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkOnRequest extends TPLinkSubmitRequest {

    public TPLinkOnRequest(final String deviceId) {
        super(deviceId, true);
    }
}

