import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(problemOneSoln());
        System.out.println(problemTwoSoln());
    }

    public static int problemOneSoln() {
        try {
            // Consume input file and read it line by line
            File input = new File("src/Day2Input.txt");
            Scanner reader = new Scanner(input);
            int sum = 0;
            while (reader.hasNextLine()) {
                // Preprocessing
                String currLine = reader.nextLine();
                // Split the line to retrieve the game number and the set data
                String[] splitResults = currLine.split(" ", 3);
                // Record the set data
                currLine = splitResults[2];
                // Record the game number
                int gameNum = Integer.parseInt(splitResults[1].substring(0,splitResults[1].length() - 1));
                // Remove all unnecessary punctuation marks from the set data
                currLine = currLine.replaceAll("[,;]", "");
                // Split the set data into an array of game numbers and associated colors
                splitResults = currLine.split(" ");

                // Calculation
                boolean validGame = true;
                // Iterate through the set data and check if any values are invalid
                for (int i = 0; i < splitResults.length; i += 2) {
                    // Retrieve the values from the set data
                    int cubeCount = Integer.parseInt(splitResults[i]);
                    String cubeColor = splitResults[i + 1];
                    if (cubeColor.equals("red")) {
                        if (cubeCount > 12) {
                            validGame = false;
                            break;
                        }
                    } else if (cubeColor.equals("green")) {
                        if (cubeCount > 13) {
                            validGame = false;
                            break;
                        }
                    } else {
                        // Case for blue
                        if (cubeCount > 14) {
                            validGame = false;
                            break;
                        }
                    }
                }
                if (validGame) {
                    sum += gameNum;
                }
            }
            return sum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int problemTwoSoln() {
        try {
            // Consume input file and read it line by line
            File input = new File("src/Day2Input.txt");
            Scanner reader = new Scanner(input);
            int sum = 0;
            while (reader.hasNextLine()) {
                // Preprocessing, see solution to Problem 1
                String currLine = reader.nextLine();
                String[] splitResults = currLine.split(" ", 3);
                currLine = splitResults[2];
                currLine = currLine.replaceAll("[,;]", "");
                splitResults = currLine.split(" ");

                // Calculation
                int minRed, minGreen, minBlue;
                minRed = minGreen = minBlue = 0;
                // Find the minimum number of cubes necessary for each color
                for (int i = 0; i < splitResults.length; i += 2) {
                    // Retrieve the values from the set data
                    int cubeCount = Integer.parseInt(splitResults[i]);
                    String cubeColor = splitResults[i + 1];
                    if (cubeColor.equals("red")) {
                        if (cubeCount > minRed) {
                            minRed = cubeCount;
                        }
                    } else if (cubeColor.equals("green")) {
                        if (cubeCount > minGreen) {
                            minGreen = cubeCount;
                        }
                    } else {
                        if (cubeCount > minBlue) {
                            minBlue = cubeCount;
                        }
                    }
                }
                // Calculate the product of the game and add it to the sum
                sum += minRed * minGreen * minBlue;
            }
            return sum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
