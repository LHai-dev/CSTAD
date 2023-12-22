package co.istad.mvcap;
import co.istad.mvcap.controller.IndexController;
import co.istad.mvcap.view.InputView;
import java.util.Scanner;

public class Main {
    // create reference object or dependency
    private static IndexController indexController;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        indexController = new IndexController();
        indexController.handleIndex(scanner);
    }
}