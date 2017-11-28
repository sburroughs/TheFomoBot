package dsburroughs.fomo.tplink.model;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkOnRequest extends dsburroughs.common.tplink.model.TPLinkSubmitRequest {

    public TPLinkOnRequest(final String deviceId) {
        super(deviceId, true);
    }
}

