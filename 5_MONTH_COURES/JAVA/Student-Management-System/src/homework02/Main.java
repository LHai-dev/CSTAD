package homework02;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ArrayList<Student> students1 = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        int option = 0;
        do {
            System.out.println("--------------- Student Management System ------------------");
            System.out.println("1.insert Student to system  ");
            System.out.println("2. Edit Student  information ");
            System.out.println("3. Delete Student profile");
            System.out.println("4. Search student profile");
            System.out.println("5. Show student information ");
            System.out.println("6. Exit");

            String strOption;
            System.out.print("Enter number your number 1 - 6: ");
            strOption = read.nextLine();
            try {
                option = Integer.parseInt(strOption);
            } catch (Exception e) {
                option = 0;
                System.out.println("Invalid Input !!!!");
            }
            switch (option) {
                case 1: {
                    Student student = new Student();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=Add new Student-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    student.input(read);
                    students1.add(student);
                    System.out.println("Successfully added.....!");
                    read.nextLine();
                    break;

                }
                case 2: {
                    Student edit = null;
                    System.out.println("Edit Information");
                    int searchEdit;
                    System.out.println("Enter ID to edit : ");
                    searchEdit = read.nextInt();

                    for (int i = 0; i < students1.size(); i++) {
                        if (searchEdit == students1.get(i).getId()) {
                            edit = students1.get(i);
                            break;
                        }
                    }
                    if (edit != null) {
                        System.out.println("Enter the new information for student:");
                        edit.input(read);
                        System.out.println("-----------------------------");

                        System.out.println("Student information updated");
                    } else {
                        System.out.println("No student found with ID " + searchEdit);
                    }

                    break;

                }
                case 3: {
                    int inputcase3;
                    System.out.println("1.Search by name ");
                    System.out.println("2.Search by ID ");
                    System.out.println("3.Search by Gender ");
                    System.out.println("4.Exit");
                    inputcase3 = read.nextInt();

                    switch (inputcase3){
                        case 1:{
                            Student student = new Student();
                            String studentDeleteByName;
                            System.out.println("Enter Name Search to delete: ");
                            studentDeleteByName = read.next();
                            boolean idFound = false;
                            for (int i = 0 ; i<students1.size();i++){
                                student = students1.get(i);
                                if(student.getName().equals(studentDeleteByName)){
                                    students1.remove(student);
                                    idFound = true;
                                    break;
                                }
                            }
                            if (!idFound){
                                System.out.println("Student not found");
                            }
                            System.out.println("Update list of student -----------");
                            break;
                        }
                        case 2:{
                            Student student = new Student();
                            int inputID2;
                            System.out.print("Enter ID to delete: ");
                            inputID2 = read.nextInt();
                            boolean isFound = true;
                            for (int i = 0 ; i <students1.size(); i++){
                                student = students1.get(1);
                                if (student.getId() == inputID2){
                                    students1.remove(student);
                                }
                            }
                            if (!isFound){
                                System.out.println("Enter not found");
                            }
                            System.out.println("update list of student---------------");
                            break;
                        }
                        case 3:{
                            String genderByDelete;
                            System.out.print("Enter gender delete: ");
                            genderByDelete = read.next();
                            boolean isFound = true;
                            for (int i = 0 ; i <students1.size(); i++){
                                if (students1.get(i).gender.equals(genderByDelete) ){
                                    students1.remove(students1);
                                    break;
                                }
                            }
                            if (!isFound){
                                System.out.println("Enter not found");
                            }
                            System.out.println("update list of student---------------");
                            break;
                        } case 4:{
                            break;
                        }
                    }







                    break;
                }
                case 4: {
                    int searchOption;
                    System.out.println("************ Search Worker***********");
                    System.out.println("1. Search By ID ");
                    System.out.println("2. Search By Name ");
                    System.out.println("3. Exit....");

                    System.out.print("Choose option 1 - 3 : ");
                    searchOption = read.nextInt();
                    switch (searchOption) {
                        case 1:
                            int searchID;
                            boolean isWorkerExist = false;
                            System.out.println("******************Search BY ID***********************");
                            System.out.println("Enter Your ID to search : ");
                            searchID = read.nextInt();

                            for (int i = 0; i < students1.size(); i++) {
                                if (searchID == students1.get(i).id) {
                                    isWorkerExist = true;
                                    students1.get(i).outputInformation();
                                }
                            }
                            if (!isWorkerExist) {
                                System.out.println("Student with ID = " + searchID + "Doesn't exist");
                            }

                            break;


                        case 2:
                            System.out.println("*********** Search By Name *********** ");
                            String searchName;
                            System.out.println("Enter name to search : ");
                            searchName = read.nextLine();

                            for (int i = 0; i < students1.size(); i++) {
                                if (searchName.equals(students1.get(i).name)) {
                                    // user exist
                                }
                            }
                    }
                    read.nextLine();

                    break;

                }
                    case 5: {
                        System.out.println("------------- Show worker information ------------- ");
                        for (int i = 0; i < students1.size(); i++) {
                            students1.get(i).outputInformation();
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("Thank you for useing this Management System");
                        break;
                    }


            }
        }
            while (option != 6) ;


    }

}





