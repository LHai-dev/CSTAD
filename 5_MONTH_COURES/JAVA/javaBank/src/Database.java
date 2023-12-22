import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Database {
    public static CreditCard creditCard (){
        CreditCard
        creditCard = new CreditCard(172212 , "limhai" , 1000.0);
        creditCard.setName("limhai");
//        creditCard.setNumber(17222);
        creditCard.setPin(1722);
        creditCard.setLimitAount(1000.0);
        creditCard.setThruDate(LocalDate.now().plus(1 , ChronoUnit.DAYS));
        return creditCard;
    };
//    public static Database getDb1(){
//       return new Database();
//    }
//    public CreditCard getDate(){
//
//    }
}
