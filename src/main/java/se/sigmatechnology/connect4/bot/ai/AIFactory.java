package se.sigmatechnology.connect4.bot.ai;

import org.apache.commons.cli.CommandLine;

/**
 * Created by msk on 2016-11-10.
 */
public class AIFactory {
    public static AI buildAI(CommandLine cmd) {
        if (cmd.hasOption("randomAI")) {
            return new RandomAI();
        }
        return new RandomAI();//defaultAI
    }
}
