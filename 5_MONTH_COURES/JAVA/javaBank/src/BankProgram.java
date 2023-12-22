public class BankProgram {
    public static void main(String[] args) {
//        Account account = new Account();
//        account.setName("limhai");
//        account.setNumber(1722);
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(172212);
        creditCard.setPin(1722);
        //check credit card exist or not
        if(Database.creditCard().getNumber().equals(creditCard.getNumber())){
            creditCard = Database.creditCard();
        }
        creditCard.Showbalance();
    }
}
