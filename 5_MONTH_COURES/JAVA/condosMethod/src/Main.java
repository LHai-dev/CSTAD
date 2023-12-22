import java.util.Scanner;

public class Main {
    static int disir = 0;
    static int disir1 = 0;
    static int colun = 0;
    static String name = null;
    static int option;
    static int floor;
    static int room;
    static String[][] condos;
    static boolean isFound;
    static Scanner read = new Scanner(System.in);

    static void InputcondoShowFloorAndroom() {
        System.out.println("-=-=-=-=-=-=-=Setting of condo-=-=-=-=-=-=-=-=-=");
        System.out.print("->Enter the number Of floor: ");
        floor = read.nextByte();
        System.out.print("Enter the number Of Room: ");
        room = read.nextByte();

        disir = 0;
        disir1 = 0;
        colun = 0;
        name = null;
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=--=");
        System.out.println("You Have Successfully set up the condo");
        System.out.println("=>Number Of Floor : " + floor + " floors");
        System.out.println("=> Number of Rooms: " + room + " rooms");
        int condo = floor * room;
        System.out.println("Total Condo: " + condo + " condos");
        condos = new String[floor][room];
    }

    static void case1Print() {
        System.out.println("-----------------Buying the Condo--------------");
        System.out.print("=> Enter Your Desired Floor( 1- " + floor + "): ");
        disir = read.nextByte();
        System.out.print("=> Enter your Desired Room( 1 -" + room + "): ");
        disir1 = read.nextByte();
        System.out.print("=> Enter Your Name: ");
        name = read.next();


        condos[disir - 1][disir1 - 1] = name;
        System.out.println("name=" + condos[disir - 1][disir1 - 1]);
        if (condos[disir - 1][disir1 - 1].equalsIgnoreCase(name)) {
            System.out.println("This Room have people buy");

        }
    }

    static void case2Print() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=sell the condo back-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("Enter the floor= ");
        disir = read.nextByte();
        System.out.print("Enter the room= ");
        disir1 = read.nextByte();
        isFound = true;
        System.out.println("Floor= " + disir);
        System.out.println("Room= " + disir1);
        System.out.println("Name: " + condos[disir - 1][disir1 - 1]);
        if (condos[disir - 1][disir1 - 1] == null) {

            System.out.println("this condos can not sell");
        } else {
            System.out.println("for sell back");
            condos[disir - 1][disir1 - 1] = null;
        }

        System.out.println("Enter 1 to Confrim and 0 to cancel");

    }

    static void condoShowOption() {
        System.out.println("#################### Welcome To limhai Condo ####################");
        System.out.println("1.Buy Condo");
        System.out.println("2.Sell Condo");
        System.out.println("3.Seach Information");
        System.out.println("4.Display Informatetion");
        System.out.println("5.Exit");
        System.out.println("-------------------------------------");
        System.out.println("->Choose Option From (1-5): ");
        option = read.nextInt();
    }

    public static void main(String[] args) {

        InputcondoShowFloorAndroom();
        do {
            condoShowOption();
            switch (option) {
                case 1 -> case1Print();
                case 2 -> case2Print();
                case 3 -> case3Print();
                case 4 -> case4Print();
                default -> System.out.println("Thank you");

            }
        } while (true);
    }

    static void case3Print() {


        System.out.println("-----------------------------------------Search Information------------------");
        System.out.println("1. Search by Owner's name: ");
        System.out.println("2. Search by floor:  ");
        System.out.println("3. Exit");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("=> Choose your option from 1 - 3 : ");
        int op = read.nextByte();
        switch (op) {
            case 1: {
                System.out.println("----------------------Search Condo By owner's Name----------------------------");
                System.out.println("please Owner name to Search : ");
                name = read.next();

//                            name = condos[disir - 1][disir1 - 1];
                if (name.equalsIgnoreCase(condos[disir - 1][disir1 - 1])) {
                    name = name;
                    System.out.println("Owner name=" + condos[disir - 1][disir1 - 1]);
                    System.out.println("Floor No= " + disir);
                    System.out.println("Room No= " + disir1);
                } else {
//                                name = null;
                    System.out.println("User: " + name + " Dosnt exist in our condos System");
                }


                break;
            }
            case 2: {
                System.out.println("------------------Search Condo By The Floor---------------------------");
                System.out.println("=> Enter The floor You Want to Search :");
                disir = read.nextByte();
                for (int row = 0; row < condos.length; row++) {//floor
                    if (disir == (row + 1)) {

                        System.out.print("floor=[" + (row + 1) + "]");

                        for (colun = 0; colun < condos[row].length; colun++) {//room

                            System.out.print(condos[row][colun] + " ");
                        }
                        System.out.println("   ");
                    }
                }
            }
        }
    }
    static void case4Print () {
        for (int row = 0; row < condos.length; row++) {//floor
            System.out.print("floor=[" + (row + 1) + "]");
            for (colun = 0; colun < condos[row].length; colun++) {//room
                System.out.print(condos[row][colun] + " ");
            }

            System.out.println(" ");
        }
    }
}
