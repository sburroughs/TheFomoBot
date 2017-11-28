package dsburroughs.common.tplink.model;

import java.util.Map;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public class TPLinkAuthResponse {

    private int errorCode;
    private Map<String, String> result;


    public int getErrorCode() {
        return errorCode;
    }

    public Map<String, String> getResult() {
        return result;
    }
}
