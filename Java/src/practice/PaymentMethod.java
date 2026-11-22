package practice;

public interface PaymentMethod {
    
    boolean pay(double amount);
    double getAmount();
}
