package com.interswitch.assignment;

import java.util.Scanner;

public class VowelDigitWordsCipher {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(checkDigits("1234helloworld"));
//        System.out.println(checkWords("helloworld"));
    }

    private int checkDigits(String str) {
//        char[] chars = str.toCharArray();
        int counter = 0;

        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                counter++;
            }
        }
        return counter;
    }

    private String checkVowels() {
        System.out.println("Enter your word: ");
        String word = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < word.length(); i++){

            char c = word.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                result.append(c + " ");
            }
        }
        return result.toString();
    }

    private String checkWords() {
        System.out.println("Enter your sentence here: ");
        String str = scanner.next();
        StringBuilder rs = new StringBuilder();
        String[] splitString = str.split(" ");
        int count = splitString.length;
        for (String word: splitString) {
            rs.append(word).append(" ");
        }
        return rs.toString()+ count;
    }

    private void display() {
        //Total number of vowels
        VowelDigitWordsCipher vowelDigitWordsCipher = new VowelDigitWordsCipher();
//        String vowels = ce.getVowels();
//        System.out.println("The vowels in the letter are: " + vowels);



//        Total number of digits
////        String digits = ce.getDigits();
//        System.out.println("The digits are: " + vowelDigitWordsCipher.checkDigits() );


        //Total number of words
        String words = vowelDigitWordsCipher.checkWords();
        System.out.println("The words are: " + words);
    }
}

