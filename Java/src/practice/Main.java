package practice;

public class Main {
    public static void main(String[] args) {
        
        PaymentMethod[] pm = {new Cash(),  new CreditCard(), new GCash(), };
        
        for(PaymentMethod p : pm){
            p.pay(500);
            System.out.println(p.getAmount());
            if (p instanceof GCash) ((GCash)p).sendReceiptToMobile();
        }

    }
}
