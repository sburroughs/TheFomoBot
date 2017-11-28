package dsburroughs.fomo.tplink.model;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkOffRequest extends dsburroughs.common.tplink.model.TPLinkSubmitRequest {

    public TPLinkOffRequest(final String deviceId) {
        super(deviceId, false);
    }

}

