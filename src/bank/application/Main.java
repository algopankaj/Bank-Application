package bank.application;

public class Main {
    public static void main(String[] args) {

        SBI.rateOfInterest=7;
        HdfcBank.rateOfInterest=6;

        SBI account1=new SBI(50000,"123","anu");
        SBI account2=new SBI(150000,"456" ,"rakshit");
        HdfcBank account3=new HdfcBank(1300000,"789" ,"mehran");

        int balance=account1.checkBalance("5343");
        System.out.println("The balance for this account is"+balance);

        int balanceCheck=account1.checkBalance("123");
        System.out.println("The balance for this account is "+ balanceCheck);

        String BankMessage = account2.addMoney(50000);
        System.out.println(BankMessage);

        String message =account3.withdrawMoney(10000,"1234");
        System.out.println(message);

        String message1=account3.withdrawMoney(10000,"789");
        System.out.println(message1);

        double interest=account1.calculateTotalInterest(7);
        System.out.println("The total interest you will get is "+interest);


    }
}