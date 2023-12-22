import java.util.Scanner;

public class main {
    private static int charSwitch(char c){
        return switch (c) {
            case 'a', 'j', 's' -> 1;
            case 'b', 'k', 't' -> 2;
            case 'c', 'l', 'u' -> 3;
            case 'd', 'm', 'v' -> 4;
            case 'e', 'n', 'w' -> 5;
            case 'f', 'o', 'x' -> 6;
            case 'g', 'p', 'y' -> 7;
            case 'h', 'q', 'z' -> 8;
            case 'i', 'r' -> 9;
            default ->  0;


        };
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String name = read.next();
        name = name.toUpperCase();
        int result = 0;

        for (int i = 0; i < name.length(); i++) {
            result += name.charAt(i);
        }
        System.out.println(number(result));
//        int num;
//        int sum =0;
//        while(result > 0 || sum > 9) {
//            if(result == 0) {
//                num = sum;
//                sum = 0;
//            }
//            sum += result % 10;
//            result /= 10;
        }




    static int number (int num){
        int sum = 0;
        while(num > 0 || sum > 9) {
            if(num == 0) {
                num = sum;
                sum = 0;
            }
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
