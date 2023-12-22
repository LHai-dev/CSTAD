package homework02;

import java.util.InputMismatchException;
import java.util.Scanner;
abstract class ClassRoom{
    String room;
   public abstract void inputClass(Scanner scanner);
   public abstract void outputClass();
}
public class Student extends Person {

     int id;
    float score;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    ClassRoom classRoom = new ClassRoom() {
        @Override
        public void inputClass(Scanner scanner) {
            System.out.print("Enter Your Class: ");
            room = scanner.next();
        }

        @Override
        public void outputClass() {

            System.out.println("class: "+room);
        }
    };

    public Student(){

    }

    public Student(float score,int id,String name, int age, String gender) {
        super(name, age, gender);
        this.id = id;
        this.score = score;
    }

    @Override
    void input(Scanner scanner ) {
            boolean validAgeInput = false;
            for (;!validAgeInput;){
                try{
                    System.out.print("Enter your ID : ");
                    id = scanner.nextInt();
                    validAgeInput = true;
                }catch (InputMismatchException ex){
                    System.out.println("Input ID again");
                    scanner.nextLine();
                }
            }
            for (;!validAgeInput;){
                try {
                    System.out.print("Enter Your Score: ");
                    score = scanner.nextFloat();
                    validAgeInput = true;
                }catch (InputMismatchException ex){
                    System.out.println("Input score agian");
                    scanner.nextLine();
                }
            }







            super.input(scanner);
            classRoom.inputClass(new Scanner(System.in));


    }

    @Override
    void outputInformation() {
        super.outputInformation();
        System.out.println("ID: "+id);
        System.out.println("Score: "+score);
        classRoom.outputClass();
    }
}
