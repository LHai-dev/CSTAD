package co.istad.mvcap.controller;

import co.istad.mvcap.view.WelcomeView;

import java.util.Scanner;

public class IndexController {
    public void handleIndex(Scanner scanner){
        WelcomeView.welcome(scanner);
    }
}
