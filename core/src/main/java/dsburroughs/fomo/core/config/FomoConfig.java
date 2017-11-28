package dsburroughs.fomo.core.config;

import dsburroughs.fomo.FomoOutputService;
import dsburroughs.fomo.LoggingOutputService;
import dsburroughs.fomo.input.FomoInputService;
import dsburroughs.fomo.input.RandomInputService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shanu on 11/20/2017.
 */
@Configuration
public class FomoConfig {

    @Bean
    public FomoInputService inputService(){
        return new RandomInputService();
    }

    @Bean
    public FomoOutputService outputService(){
        return new LoggingOutputService();
    }

}
