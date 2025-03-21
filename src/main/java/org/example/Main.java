package org.example;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        checkForPalindrome("I did, did I?");
        checkForPalindrome("Racecar");
        checkForPalindrome("hello");
        checkForPalindrome("Was it a car or a cat I saw ?");

        System.out.println(convertDecimalToBinary(5));  // 101
        System.out.println(convertDecimalToBinary(6));  // 110
        System.out.println(convertDecimalToBinary(13)); // 1101
        System.out.println(convertDecimalToBinary(45)); // 101101
    }

    public static boolean checkForPalindrome(String input){
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ENGLISH);
        //System.out.println(cleanedInput);
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();

        System.out.println(reversedInput.equals(cleanedInput));
        return reversedInput.equals(cleanedInput);
    }

    //Decimal to binary:
    // Sayıyı 2’ye böl, kalanı not et.
    //Bölümle devam et, tekrar 2’ye böl, kalanı not et.
    //Bölüm 0 olana kadar devam et.
    //Son kalan en üst basamakta olacak şekilde, tersten yaz.
    public static String convertDecimalToBinary(int number){
        if(number == 0) return "0"; //0 için özel durum

        Stack<Integer> stack = new Stack<>(); //Kalanları saklamak için Stack
        //Stack (Yığın) veri yapısı, LIFO prensibiyle çalıştığı için kalanları doğru sırada alabiliriz.
        //LIFO: Last In First Out (son giren ilk çıkar)

        while (number > 0) {
            stack.push(number % 2);  //Kalanı stack'e ekle
            number /= 2;  //Sayıyı 2'ye böl
        }

        StringBuilder binary = new StringBuilder();

        while (!stack.isEmpty()) {
            binary.append(stack.pop()); //Stack'ten çıkarıp sırayla ekle
        }

        return binary.toString();
    }

    //ALTERNATIVE:
    public static String convertDecimalToBinaryAlternative(int number) {
        if (number == 0) return "0";

        StringBuilder binary = new StringBuilder(); // Boş bir string oluştur

        while (number > 0) {
            binary.insert(0, number % 2); // Kalanı en başa ekle
            number /= 2; // Sayıyı 2'ye böl
        }

        return binary.toString();
    }

}