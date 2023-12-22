package homework02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    String name;
    int age;
    String gender;


    public String getName() {
        return name;


    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    Person(){

    }
    void input(Scanner scanner ){
        System.out.print("Enter Your Name: ");
        name = scanner.next();
        boolean validAgeInput = false;
        for (; !validAgeInput ;){
            try {
                System.out.print("Enter Your age : ");
                age = scanner.nextInt();
                validAgeInput = true;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input for age. Please input anumber");
                scanner.nextLine();
            }
        }
        System.out.print("Enter Your Gender : ");
        gender = scanner.next();

    }
    void outputInformation() {
        System.out.println("---------------------------------");
        System.out.println("Age: "+age);
        System.out.println("Name : " + name);
        System.out.println("Gender :" + gender);

    }
}
