package com.company;

public class BracketsValidator {

    public static final char OPEN_BRACKET_CHAR = '(';
    public static final char CLOSED_BRACKET_CHAR = ')';

    public static void main(String[] args) {
        String input = "(s ((f))(f)g )";
        System.out.println(input);
        System.out.println(" isValid            "+isValid(input));
        System.out.println(" isValidUsingStream "+isValidUsingStream(input));
    }

    private static boolean isValid(String inputString) {
        int currentBracketCount = 0;
        for (char ch : inputString.toCharArray()) {
            if (OPEN_BRACKET_CHAR == ch) {
                currentBracketCount++;
            } else if (CLOSED_BRACKET_CHAR == ch) {
                if (currentBracketCount == 0) {
                    return false;
                }
                currentBracketCount--;
            }
        }
        return currentBracketCount == 0;
    }

    public static boolean isValidUsingStream(String inputString) {
        int[] currentBracketCount = new int[1];
        boolean isValidBrackets;
        isValidBrackets = inputString
                .chars()
                .map(ch -> method(currentBracketCount, ch))
                .anyMatch(ch -> ch < 0);
        return !isValidBrackets && currentBracketCount[0] == 0;
    }
    private static int method(int[] currentBracketCount, int inputChar) {
        if (inputChar==OPEN_BRACKET_CHAR)
            currentBracketCount[0]++;
        if (inputChar==CLOSED_BRACKET_CHAR)
            currentBracketCount[0]--;
        return currentBracketCount[0];
    }

}