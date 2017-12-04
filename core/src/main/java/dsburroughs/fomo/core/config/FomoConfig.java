package dsburroughs.fomo.core.config;

import dsburroughs.fomo.FomoOutputService;
import dsburroughs.fomo.LoggingOutputService;
import dsburroughs.fomo.common.discord.DiscordConfig;
import dsburroughs.fomo.input.FomoInputService;
import dsburroughs.fomo.input.RandomInputService;
import dsburroughs.fomo.input.discord.DiscordInputService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by shanu on 11/20/2017.
 */
@Configuration
@Import(DiscordConfig.class)
public class FomoConfig {

    @Bean
    public FomoInputService inputService(RandomInputService discordInputService){
        return discordInputService;
    }

    @Bean
    public FomoOutputService outputService(){
        return new LoggingOutputService();
    }

}
