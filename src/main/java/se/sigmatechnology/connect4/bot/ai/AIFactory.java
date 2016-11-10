package se.sigmatechnology.connect4.bot.ai;

import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by msk on 2016-11-10.
 */
@Configuration
public class AIFactory {

    @Autowired
    private CommandLine commandLine;


    @Bean
    public AI buildAI() {
        if (commandLine.hasOption("randomAI")) {
            return new RandomAI();
        }
        return new RandomAI();//defaultAI
    }

}
