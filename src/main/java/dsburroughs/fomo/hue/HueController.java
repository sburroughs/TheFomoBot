package dsburroughs.fomo.hue;

import dsburroughs.fomo.discord.DiscordInputService;
import dsburroughs.fomo.web.FomoLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sburroughs on 10/14/2017.
 */
@RestController
@ConditionalOnProperty("hue.enabled")
public class HueController {

    @Autowired
    private PhillipsHueService phillipsHueService;

    @RequestMapping("/hue")
    private String discord() {
        phillipsHueService.output(FomoLevel.HIGH);
        return "FUCK YEAH. dem lighty boys";

    }

}
