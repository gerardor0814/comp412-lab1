public class Main {
    public static void main(String[] args) {
        String helpStatement = """
                Command Syntax:
                        ./lab1_ref [flags] filename

                Required arguments:
                        filename  is the pathname (absolute or relative) to the input file

                Optional flags:
                        -e       suppress error messages
                        -h       prints this message
                        -l       Opens log file "./Log" and starts logging.
                        -v       prints version number

                At most one of the following three flags:
                        -s       prints tokens in token stream
                        -p       invokes parser and reports on success or failure
                        -r       prints human readable version of parser's IR
                If none is specified, the default action is '-p'.""";
        String fileName = "";
        int option = 0;
        boolean multipleFlags = false;
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-h")) {
                System.out.println(helpStatement);
                return;
            }
            else if (args[i].equals("-s")){
                if (option != 0){
                    multipleFlags = true;
                }
                option = 1;
            }
            else if (args[i].equals("-p")){
                if (option != 0) {
                    multipleFlags = true;
                }
                if (option < 2) {
                    option = 2;
                }
            }
            else if (args[i].equals("-r")) {
                if (option != 0) {
                    multipleFlags = true;
                }
                if (option < 3) {
                    option = 3;
                }
            }
            else {
                if (fileName.isEmpty()) {
                    fileName = args[i];
                } else {
                    System.out.println("ERROR:  Attempt to open more than one input file.\n");
                    System.out.println(helpStatement);
                    return;
                }
            }
        }
        if (multipleFlags){
            System.out.println("ERROR:  Multiple command-line flags found.\n" +
                    "        Try '-h' for information on command-line syntax.");
        }

        if (option == 0){
            option = 2;
        }
    }
}