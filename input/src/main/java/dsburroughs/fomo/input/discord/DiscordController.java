package dsburroughs.fomo.input.discord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sburroughs on 10/14/2017.
 */
@RestController
@ConditionalOnProperty("discord.enabled")
public class DiscordController {

    @Autowired
    private DiscordInputService discordInputService;

    @RequestMapping("/discord")
    private String discord() {
        discordInputService.getLevel();
        return "FUCK YEAH. discord";

    }

}
