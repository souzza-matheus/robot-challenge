import utils.Helper;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String heading = "";
        int[] position = new int[2];
        int[] board = new int[2];
        String robotOne = "";
        String robotTwo = "";
        int count = 0;
        Helper helper = new Helper();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Board size:");
        String userBoardDeclaration = scanner.nextLine();
        // Split the input string into an array of strings
        String[] inputArray = userBoardDeclaration.split(" ");

        // Convert the strings to integers and save in the int array
        for (int i = 0; i < inputArray.length; i++) {
            board[i] = Integer.parseInt(inputArray[i]);
        }


        while(count<2){

            System.out.println("Robot Position:");
            String userPositionDeclaration = scanner.nextLine();

            String[] positionArray = userPositionDeclaration.split(" ");
            for (int i = 0; i < positionArray.length; i++) {
                if (i < 2) {
                    position[i] = Integer.parseInt(positionArray[i]);
                }
                heading = positionArray[2];
            }

            String instructions = scanner.nextLine();

            if(count == 0){
                robotOne =helper.executeInstructions(instructions, heading, position);
            }else{
                robotTwo = helper.executeInstructions(instructions, heading, position);
            }
            count ++;
        }
        System.out.println(robotOne +"\n" + robotTwo);
    }
}
