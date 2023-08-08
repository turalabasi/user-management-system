package util;

import java.util.Scanner;

public class InputUtil {
    public static String inputRequiredString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }

    public static byte inputRequiredByte(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextByte();
    }

    public static long inputRequiredLong(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLong();
    }
}