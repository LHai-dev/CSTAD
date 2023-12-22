public class Account {
    private Integer number;
    private String name;
    private Double balance;
    public Account(){

    }

    public Account(Integer number , String name, Double balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }
//    public Account(){
////    this.balance = Database.getDb1().getDate().getBalance();
//    }
//    public Account(Integer number, String name, Double balance){
//        this.number = number;
//        this.name = name;
//        this.balance = balance;
//    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double amount){
        if ( amount== 0){
            System.out.println("No money");
            return;
        }
        if(amount < 0){
            System.out.println("No No");
            return;
        }
        amount += balance;
    }
    public void witdrawal(Double amount){
        if(amount < 0){
            System.out.println("");
            return;
        }
        if (amount == 0){
            System.out.println("");
            return;
        }
        if (amount < balance){
            System.out.println("");
            return;
        }
        balance -= amount;

    }
    public void Showbalance(){
        System.out.println("Account Informateion");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("act No"+ number);
        System.out.println("Balance"+ balance);
    }
}
