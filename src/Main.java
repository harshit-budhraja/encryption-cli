/*
 * Uses the classes Encryption.java and Base64.java shipped along with
 * this class. Do not remove these classes as they form the "required"
 * components of the parser.
 */

/**
 *
 * @author harshitbudhraja
 */
public class Main {  

    // Static Variables
    private static Encryption encryption = null;
    private static String iText = null;
    
    /*
    * A utility method to encrypt the incoming string
    */
    private static String encrypt(String plainText) {
        return encryption.encryptOrNull(plainText).trim();
    }
    

    /*
    * A utility method to decrypt the incoming cipher string
    */
    private static String decrypt(String encText) {
        return encryption.decryptOrNull(encText).trim();
    }

    /*
    * A utility method to print text
    */
    public static void printText(String t) {
        System.out.println(t);
    }

    /*
    * A utility method to print help text
    */
    public static void printHelp() {
        System.out.println("======================================================================");
        System.out.println("                           Encryption CLI");
        System.out.println("======================================================================");
        System.out.println("                    Developed by Harshit Budhraja");
        System.out.println("This CLI acts as a utility to perform encryption and decryption of texts\nusing AES algorithm in CBC mode by default. All \"algorithm\" credits to\ncom.github.simbiose:Encryption (https://github.com/simbiose/Encryption).");
        System.out.println("\nusage: java <classname> [--key <YOUR_KEY>] [--salt <YOUR_SALT>] <args>");
        System.out.println("There are two arguments which are necessary to be specified:");
        System.out.println("    --mode\t0 (for decryption)");
        System.out.println("          \t1 (for encryption)");
        System.out.println("    --text\tThe text to be encrypted or decrypted");
        System.out.println("The other options available in the CLI are explained below:");
        System.out.println("    --help\tTo show this help text");
        System.out.println("    --salt\tThe salt can typically be a randomly generated text, but\n\t\tit is needed to decrypt the text back.");
        System.out.println("    --key\tThis is your secret key that is used for ciphering.");
    }

    
   /*****************************************************
    * A static class secureKey to extract the secret key
    ******************************************************/ 
    static class secureKey {
        private static String mKey = "mYkEy";
        private static String mSalt = "MySaLt";
        public static String getKey() {
            return mKey;
        }
        public static String getSalt() {
            return mSalt;
        }
        public static void setKey(String key) {
            mKey = key;
        }
        public static void setSalt(String salt) {
            mSalt = salt;
        }
    }
    
    
    /*
    * MAIN METHOD
    */
    public static void main(String[] args) {
        encryption = Encryption.getDefault(secureKey.getKey(), secureKey.getSalt(), new byte[16]);
        int mode = -1;
        if(args.length > 0) {
            for(int i=0;i<args.length;i++) {
                if(args[i].equals("--help")) {
                    printHelp();
                    return;
                }
                if(args[i].equals("--key")) {
                    secureKey.setKey(args[i+1]);
                    encryption = Encryption.getDefault(secureKey.getKey(), secureKey.getSalt(), new byte[16]);
                }
                if(args[i].equals("--salt")) {
                    secureKey.setSalt(args[i+1]);
                    encryption = Encryption.getDefault(secureKey.getKey(), secureKey.getSalt(), new byte[16]);
                }
                if(args[i].equals("--mode")) {
                    try {
                        mode = Integer.valueOf(args[i+1]);
                        if(!(mode == 0 || mode == 1)) {
                            printText("IllegalArgumentException: unspecified mode 0 or 1");
                            return;
                        }
                    } catch(IndexOutOfBoundsException e) {
                        printText("IndexOutOfBoundsException: unspecified mode 0 or 1");
                    } catch(NumberFormatException e) {
                        printText("IllegalArgumentException: illegal mode specified");
                    }
                }
                if(args[i].equals("--text")) {
                    try {
                        iText = args[i+1];
                        if(iText == null) {
                            printText("IllegalArgumentException: unspecified text");
                            return;
                        }
                    } catch(IndexOutOfBoundsException e) {
                        printText("IndexOutOfBoundsException: unspecified text");
                    }
                }     
            }
            if(mode == 0) {
                printText(decrypt(iText));
            }
            else if(mode == 1) {
                printText(encrypt(iText));
            }
        }
        else {
            printHelp();
            return;
        }
    }
}