package co.istad.mvcap.view;

import java.util.Scanner;

public class InputView {
    //done
    public static Integer getInputNumber(Scanner scanner){
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException ex){
            System.out.println("Allow Number only...!");
        }
        return 0;
    }
}
