import java.util.Scanner;

public class Main {
    // 1. parenthesesCheck
        public static boolean parenthesesCheck (String s){
            boolean result = true;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.substring(i, i + 1).equals("(")) {
                    count++;
                } else {
                    count--;
                }
            }
            if (count < 0) {
                result = false;
            }
            if (s.length()<=1){
                result = false;
            }
            return result;
        }

        // 2. reverseInteger
        public static String reverseInteger ( int n){
            String integer = Integer.toString(n);
            String result = "";
            for (int i = integer.length() - 1; i >= 0; i--) {
                result += integer.substring(i, i + 1);
            }
            return result;
        }


        // 3. encryptThis
        public static String encryptWord (String word){
            String wordnew = "";
            int letter1 = (int) word.charAt(0);
            if (word.length() == 1) {
                return String.valueOf(letter1);
            } else if (word.length() == 2) {
                return letter1 + word.substring(1);
            }
            String letter2 = word.substring(word.length() - 1);
            String lettermiddle = word.substring(2, word.length() - 1);
            String letterlast = word.substring(1, 2);
            wordnew = letter1 + letter2 + lettermiddle + letterlast;
            return wordnew;
        }
        public static String encryptThis (String input){
            String result = "";
            String[] words = input.split(" ");
            for (int i = 0; i < words.length-1; i++) {
                String word = words[i];
                String add = encryptWord(word);
                result = result + add + " ";
            }
            String wordlast = words[words.length-1];
            String add2 = encryptWord(wordlast);
            result += add2;
            return result;
        }


        // 4. decipherThis
        public static String decipherWord (String word) {
            int front = Integer.valueOf(word.substring(0, 2));
            int start = 2;
            if (word.length()>2 && word.charAt(2) >= '0' && word.charAt(2) <= '9') {
                front = Integer.valueOf(word.substring(0, 3));
                start = 3;
            }
            char character = (char) front;
            String letter1 = String.valueOf(character);

            if (word.length() == start) {
                return letter1;
            }
            else if (word.length() == start + 1) {
                return letter1 + word.substring(start);
            }
            String letter2 = word.substring(start, start + 1);
            String middle = word.substring(start + 1, word.length() - 1);
            String last = word.substring(word.length() - 1);
            String result = letter1 + last + middle + letter2;
            return result;
        }
        public static String decipherThis (String input){
            String result = "";
            String[] words = input.split(" ");
            for (int i = 0; i < words.length-1; i++) {
                String word = words[i];
                String add = decipherWord(word);
                result = result + add + " ";
            }
            String wordlast = words[words.length-1];
            String add2 = decipherWord(wordlast);
            result += add2;
            return result;
        }
}
