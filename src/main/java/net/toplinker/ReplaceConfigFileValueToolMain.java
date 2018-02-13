package net.toplinker;

import org.apache.commons.cli.*;

/**
 * Created by henry on 2018/2/13.
 */
public class ReplaceConfigFileValueToolMain {
    public static void main(String[] args){
        if (args.length == 0) {
            System.out.println("Please use --help!");
            return;
        }

        Options options = new Options();
        options.addOption("f", "file", true, "input config file path");
        options.addOption("k", "key", true, "input keys split with ','");
        options.addOption("v", "value", true, "input values split with ','");
        options.addOption("g", "global", false, "use global replace");
        options.addOption("d", "description", true, "Description");
        options.addOption("h", "help", false, "help");

        String fileStr = "";
        String keys = "";
        String values = "";
        Boolean isGlobal = false;

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("help")) {
                System.out.println("In help");
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("ls", options);
                return;
            }

            if (line.hasOption("file")) {
                fileStr = line.getOptionValue("file");
            }

            if (line.hasOption("key")) {
                keys = line.getOptionValue("key");
            }

            if (line.hasOption("value")) {
                values = line.getOptionValue("value");
            }

            if(line.hasOption("global")){
                isGlobal = true;
            }

            if (line.hasOption("description")) {
                //TODO 介绍如何使用该工具
                System.out.println("");
                return;
            }

            System.out.println("fileStr = " + fileStr);
            System.out.println("keys = " + keys);
            System.out.println("values = " + values);
            System.out.println("global = " + isGlobal);
        } catch (ParseException pe) {
            System.out.println("error");
            return;
        }
    }
}
