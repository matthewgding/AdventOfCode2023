import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(problemOneSoln());
        System.out.println(problemTwoSoln());
    }

    public static int problemOneSoln() {
        try {
            // Open the provided input file and read it line by line
            File input = new File("src/Day1Input.txt");
            Scanner reader = new Scanner(input);
            int sum = 0;
            while (reader.hasNextLine()) {
                // Get the next line in the document
                String currLine = reader.nextLine();
                // Extract the relevant digits from the line and add them to the sum
                sum += getCalibrationVal(currLine);
            }
            return sum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int problemTwoSoln() {
        try {
            // Open the provided input file and read it line by line
            File input = new File("src/Day1Input.txt");
            Scanner reader = new Scanner(input);
            int sum = 0;
            while (reader.hasNextLine()) {
                // Get the next line in the document
                String currLine = reader.nextLine();
                // Generate a string consisting of only numeric characters
                String digitOnlyLine = getDigitsOnly(currLine);
                // Extract the relevant digits from the line and add them to the sum
                sum += getCalibrationVal(digitOnlyLine);
            }
            return sum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static int getCalibrationVal(String currLine) {
        String firstDigit = "", secondDigit = "";
        // Extract the leftmost digit in the line
        for (int i = 0; i < currLine.length(); i++) {
            if (Character.isDigit(currLine.charAt(i))) {
                firstDigit = String.valueOf(currLine.charAt(i));
                break;
            }
        }
        // Extract the rightmost digit in the line
        for (int j = currLine.length() - 1; j >= 0; j--) {
            if (Character.isDigit(currLine.charAt(j))) {
                secondDigit = String.valueOf(currLine.charAt(j));
                break;
            }
        }
        // Combine the extracted digits into a two-digit number
        String calibrationVal = firstDigit + secondDigit;
        // Return the two-digit number as an integer value
        return Integer.parseInt(calibrationVal);
    }

    private static String getDigitsOnly(String s) {
        // Use a StringBuilder object to create the string of numeric characters
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                // Directly append any numeric character to the string
                out.append(currChar);
            } else {
                // At each non-digit character, check if it starts a substring that is a
                // English text representation of any positive digit
                switch (currChar) {
                    case 'o':
                        // When an 'o' is encountered, it is possible that it begins a substring "one"
                        if (i + 3 <= s.length() && s.startsWith("one", i)) {
                            // Directly append the numerical representation of the digit
                            out.append(1);
                        }
                    case 't':
                        // when a 't' is encountered, it is possible that it begins a substring
                        // either "two" or "three"
                        if (i + 3 <= s.length() && s.startsWith("two", i)) {
                            out.append(2);
                        } else if (i + 5 <= s.length() && s.startsWith("three", i)) {
                            out.append(3);
                        }
                    case 'f':
                        if (i + 4 <= s.length() && s.startsWith("four", i)) {
                            out.append(4);
                        } else if (i + 4 <= s.length() && s.startsWith("five", i)) {
                            out.append(5);
                        }
                    case 's':
                        if (i + 3 <= s.length() && s.startsWith("six", i)) {
                            out.append(6);
                        } else if (i + 5 <= s.length() && s.startsWith("seven", i)) {
                            out.append(7);
                        }
                    case 'e':
                        if (i + 5 <= s.length() && s.startsWith("eight", i)) {
                            out.append(8);
                        }
                    case 'n':
                        if (i + 4 <= s.length() && s.startsWith("nine", i)) {
                            out.append(9);
                        }
                }
            }
        }
        return out.toString();
    }
}