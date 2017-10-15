package dsburroughs.fomo.tplink;

import dsburroughs.fomo.web.FomoLevel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sburroughs on 10/14/2017.
 */
@RestController
@ConditionalOnProperty("tplink.enabled")
public class TPLinkController {

    private TPLinkService tpLinkService;

    @RequestMapping("/tplink")
    private String tplink() {
        tpLinkService.output(FomoLevel.HIGH);
        tpLinkService.finaloutput();
        return "FUCK YEAH. dem tp boys";

    }
}
