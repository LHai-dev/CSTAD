import java.util.*;

class Account{
    int id;
    String ownerName;
    double balance;
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
public class Main {
    //acc id owner balance
    //add acc add edit remove show
    //show account information
    // 1 . descending order by account_id
    // 2.  ascending order by account_id
    // 3. descendinder order by balance
    public static void main(String[] args) {

        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account infor");
            System.out.println("5. Exit ");
            System.out.println("Choose option ( 1 - 5 ) : ");
            option  = read.nextInt();

            switch (option){
                case  1 :
                    // enter account information
                    // object add list
                    //accountList.add();
                    System.out.println("Enter your account infor");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = read.nextInt();
                    System.out.print("Name:");
                    read.nextLine();
                    acc.ownerName = read.nextLine();
                    System.out.print("Balance:");
                    acc.balance = read.nextInt();

                    accountList.add(acc);
                    //Iterator<String> i = accountList.iterator();

                    break;
                case 2 :
                    boolean idIsExist = false;
                    System.out.println(" Edit Account  (by_id) ");
                    int editByID = read.nextInt();
                    for (Account account : accountList){
                        if(account.id == editByID){
                            idIsExist = true;
                            System.out.println("---------------Enter new account information-----------");
                            System.out.print("Input new account Name : ");
                            read.nextLine();
                            account.ownerName = read.nextLine();
                            System.out.print("Input new Balance : ");
                            account.balance = read.nextDouble();
                            System.out.println("Account with ID : " + editByID + " has updated successfully.");
                        }
                    }if(!idIsExist) {
                    System.out.println("Wrong ID, Please input ID again.");
                    }
                    break;
                case 3 : break;
                case 4 :
                    int showOption ;
                    System.out.println("Show account nformation");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descendig order by balance ");

                    System.out.println("Choose show option : ");
                    showOption =  read.nextInt();
                    switch (showOption){
                        case 1:
                            Collections.sort(accountList, Comparator.comparingInt(a -> a.id));
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 2:
                            Collections.sort(accountList, Comparator.comparingInt(Account::getId).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 3:
                            Collections.sort(accountList, Comparator.comparingDouble(Account::getBalance).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("Exit the program....!");break;
                default:
                    System.out.println("choose again from(1-5)");
            }
        }while(option  !=5);

    }
}