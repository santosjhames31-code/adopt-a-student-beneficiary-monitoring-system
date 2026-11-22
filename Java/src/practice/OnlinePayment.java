package practice;

abstract class OnlinePayment implements PaymentMethod{

    public boolean pay(double amount){
        System.out.println("Already payed");
        return true;
    }

    boolean validateAccount(){
        return true;
    }

    abstract void processTransaction();
}

class GCash extends OnlinePayment{

    double amount;

    public boolean pay(double amount){
        System.out.println("Gcash");
        this.amount = amount;
        return amount > 0;
    }

    @Override
    void processTransaction() {
        if(validateAccount()) pay(amount);
    }

    void sendReceiptToMobile(){
        System.out.println("GCash Receipt sent");
    }

    public double getAmount(){
        return this.amount;
    }

}

class CreditCard extends OnlinePayment{
    
    double amount;

    public boolean pay(double amount){
        System.out.println("Credit Card");
        this.amount = amount;
        return amount > 0;
    }

        @Override
    void processTransaction() {
        if(validateAccount()) pay(amount);
    }

    public double getAmount(){
        return amount;
    }

}

class Cash implements PaymentMethod{
    
    double amount;

    public boolean pay(double amount){
        System.out.println("Cash");
        this.amount = amount;
        return amount > 0;
    }

       public double getAmount(){
        return amount;
    }

}