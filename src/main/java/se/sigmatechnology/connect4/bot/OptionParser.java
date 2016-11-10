package se.sigmatechnology.connect4.bot;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by msk on 2016-11-10.
 */
@Configuration
public class OptionParser {

    private final static Logger LOG = LoggerFactory.getLogger(OptionParser.class);

    @Bean
    public CommandLine parseOptions() {
        String[] args = System.getProperty("sun.java.command").split(" ");
        Options options = new Options();
        //Common options
        options.addOption(
                Option.builder("url")
                        .desc("URL of game server")
                        .hasArg()
                        .required()
                        .build());
        options.addOption("help", "print this message");

        //AI options
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(
                Option.builder("randomAI")
                        .desc("AI that randomly selects column")
                        .build());
        options.addOptionGroup(optionGroup);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (Exception e) {
            LOG.error("Error parsing parameters");
        }
        if (cmd == null || cmd.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar <jar_name> <opts>", options);
            return null;

        }
        return cmd;
    }

}
