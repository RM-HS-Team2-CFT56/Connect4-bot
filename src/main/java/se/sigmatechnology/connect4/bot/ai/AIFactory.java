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
        } else if (commandLine.hasOption("sequentialFillAI")) {
            return new SequentialFillAI();
        } else if (commandLine.hasOption("intelligentAI")) {
            return new IntelligentAI();
        } else if (commandLine.hasOption("columnFillAI")) {
            return new ColumnFillAI();
        }
        return new RandomAI();//defaultAI
    }

}
