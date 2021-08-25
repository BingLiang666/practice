package main;

/** A class that contains several methods for manipulating strings */
public class StringHelper {

    /**
     * Returns the number of vowels (letters a, e, i, o, u)
     * in a given string.
     * @param message
     * @return the number of vowels
     */
    public static int countVowels(String message) {
        //TODO: Replace with your code.
        int count = 0;
        String vowels = "aeiou";
        for (int i = 0; i < message.length(); i++) {
            for(int j =0; j < 5; j++) {
                if (message.charAt(i) == vowels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Returns the message encrypted using "Ceasar cipher"
     * with the given shift amount.
     *
     * If the shift is greater than 26 the method returns null.
     * If the message contains any characters that are not upper
     * or lower case letters the method returns null.
     *
     * Example: (abc, 2) -> cde
     * 'a' was shifted by two characters (became 'c'),
     * 'b' became 'd', 'c' became 'e'.
     * @param message
     * @param shift
     * @return
     * @author Prof. Rollins
     */
    public static String encrypt(String message, int shift) {
        //TODO: Replace with your code.
        char encrypted[] = new char[message.length()];
        char ch;
        for (int i = 0; i < message.length(); i++) {
            ch = message.charAt(i);
            if (!(((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch <= 'Z')))) {
                return null;
            }
        }
        if (shift <= 26) {
            for(int i = 0; i < message.length(); i++) {
                ch = message.charAt(i);
                if ((ch >= 'a') && ch <= 'z') {
                    encrypted[i] = (char) ('a' + ((ch - 'a' + shift) % 26));
                } else {
                    if ('Z' - ch < shift) {
                        encrypted[i] = (char) (ch - 'Z' - 1 + shift + 'A');
                    } else {
                        encrypted[i] = (char) (ch + shift);
                    }
                }
            }
            String encrypted1 = new String(encrypted);
            return encrypted1;
        }
        return null;
    }

    /** Main method: runs methods of class StringHelper */
    public static void main(String[] args) {
        String s = "hello";
        System.out.println("Original string: " + s);
        System.out.println("Number of vowels: " + StringHelper.countVowels(s));
        System.out.println("After encrypting: " + StringHelper.encrypt(s, 3));
    }
}
