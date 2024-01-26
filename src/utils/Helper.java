package utils;

import java.util.Arrays;
import java.util.Objects;

public class Helper {

    public String executeInstructions(String command, String currentHeading, int[] currentPosition) {
        String[] instructionArray = command.split(" ");

        for (String instruction : instructionArray) {
            if (instruction.equalsIgnoreCase("L") || instruction.equalsIgnoreCase("R")) {
                currentHeading = updateHeading(instruction, currentHeading);
            } else if (instruction.equalsIgnoreCase("M")) {
                moveForward(currentHeading, currentPosition);
            }
        }

        return currentPosition[0] + " " + currentPosition[1] + " " + currentHeading;
    }

    private String updateHeading(String turnDirection, String currentHeading) {
        if (Objects.equals(currentHeading, "N")) {
            currentHeading = (turnDirection.equalsIgnoreCase("L")) ? "W" : "E";
        } else if (Objects.equals(currentHeading, "E")) {
            currentHeading = (turnDirection.equalsIgnoreCase("L")) ? "N" : "S";
        } else if (Objects.equals(currentHeading, "S")) {
            currentHeading = (turnDirection.equalsIgnoreCase("L")) ? "E" : "W";
        } else if (Objects.equals(currentHeading, "W")) {
            currentHeading = (turnDirection.equalsIgnoreCase("L")) ? "S" : "N";
        }

        return currentHeading;
    }

    private void moveForward(String currentHeading, int[] currentPosition) {
        // Update position based on the current heading
        switch (currentHeading) {
            case "N":
                currentPosition[1]++;  // Move north
                break;
            case "E":
                currentPosition[0]++;  // Move east
                break;
            case "S":
                currentPosition[1]--;  // Move south
                break;
            case "W":
                currentPosition[0]--;  // Move west
                break;
        }
    }
}
