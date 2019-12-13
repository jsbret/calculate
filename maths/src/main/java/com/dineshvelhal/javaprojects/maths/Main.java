package com.dineshvelhal.javaprojects.maths;

import org.apache.commons.cli.*;

public class Main {

    private static HelpFormatter formatter = new HelpFormatter();

    public static void main(String[] args) {
// create the command line parser
        CommandLineParser parser = new DefaultParser();

// create the Options
        Options options = new Options();
        options.addOption("a", "number a", true, "");
        options.addOption("b", "number b", true, "");
        options.addOption("op", "operation", true, "+,-,/,*");

        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            int a = 0;
            int b = 0;
            String op = "+";

            if(line.hasOption("a")){
                a = Integer.valueOf(line.getOptionValue("a"));
            }else{
                displayHelp(options);
                System.exit(1);
            }

            if(line.hasOption("b")){
                b = Integer.valueOf(line.getOptionValue("b"));
            }else{
                displayHelp(options);
                System.exit(1);
            }

            if(line.hasOption("op")){
                op = line.getOptionValue("op");
            }else{
                displayHelp(options);
                System.exit(1);
            }

            Math math = new Math();

            switch (op){
                case "+":
                    System.out.println(math.add(a,b));
                    return;
                case "-":
                    System.out.println(math.subtract(a,b));
                    return;
                case "/":
                    System.out.println(math.divide(a,b));
                    return;
                case "*":
                    System.out.println(math.multiply(a,b));
                    return;
            }

            System.exit(0);

        } catch (ParseException exp) {

            displayHelp(options);
            System.out.println("Unexpected exception:" + exp.getMessage());
            System.exit(1);
        }
    }

    private static void displayHelp(Options options) {
        formatter.printHelp("ant", options);
    }
}
