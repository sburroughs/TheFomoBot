package dsburroughs.fomo.common.discord;

import net.dv8tion.jda.core .AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

/**
 * Created by Sburroughs on 10/13/2017.
 */
@Configuration
@ConditionalOnProperty("discord.enabled")
public class DiscordConfig {

    @Value("${discord.token}")
    private String TOKEN;

    @Bean
    public JDA getDefaultJDA() throws LoginException, InterruptedException, RateLimitedException {
        System.out.println("THEEEEE TOKEN!!!!!!!: " + TOKEN);

        JDA jda = new JDABuilder(AccountType.BOT).setToken(TOKEN).buildBlocking();
//        System.out.println("YEEE: " + jda.getGuilds().get(0).getDefaultChannel().getName());

        return jda;
    }

}
