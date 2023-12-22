import java.time.LocalDate;

public class CreditCard extends Account{
    private Integer pin;
    private Double limitAount;
    private LocalDate thruDate;

    public CreditCard(Integer number , String name , Double balance){
        super(number , name , balance);
    }

    public CreditCard() {

    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Double getLimitAount() {
        return limitAount;
    }

    public void setLimitAount(Double limitAount) {
        this.limitAount = limitAount;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }


    @Override
    public void deposit(Double amount) {
//        Integer mtPin = Database.getDb1().getDate().getPin();
//        if(!Objects.equals(pin , mtPin)){
//        System.out.println("Incorrect");
//        return;
//    }
//        if (thruDate.isAfter(Database.getDb1().getDate().getThruDate())){
//            System.out.println("your Card is Expist");
//            return;
//
//        }
//        super.deposit(amount);
    }

    @Override
    public void witdrawal(Double amount) {
//        Integer mtPin = Database.getDb1().getDate().getPin();

//        if(!Objects.equals(pin , mtPin)){
//            System.out.println("Incorrect");
//            return;
//        }
        if (amount > limitAount){
            System.out.println("Over the limit amount");
            return;
        }
//        if (thruDate.isAfter(Database.getDb1().getDate().getThruDate())){
//            System.out.println("your Card is Expist");
//            return;
//
//        }
        super.witdrawal(amount);
        }

    @Override
    public void Showbalance() {
        super.Showbalance();
        System.out.println("pin:" + pin);
        System.out.println("Limit Amount: "+limitAount);
        System.out.println("Thru Date :"+ thruDate);
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "pin=" + pin +
                ", limitAount=" + limitAount +
                ", thruDate=" + thruDate +
                '}';
    }
}



