package bank.application;

import java.util.UUID;

public class SBI implements  BankInterface{

    private int balance;
    private String accountNo;
    private String passowrd;
    private String name;
    public static double  rateOfInterest;

    public SBI(int balance, String passowrd, String name) {
        this.accountNo= UUID.randomUUID().toString();
        this.balance = balance;
        this.passowrd = passowrd;
        this.name = name;
    }

    @Override
    public int checkBalance(String password) {
       if(password==this.passowrd)
           return balance;
       return -1;
    }

    @Override
    public String addMoney(int money) {
       balance=balance+money;

       String message=money+" Has been added to the account "+accountNo +"and the " +
               "curent balance is "+balance;
       return message;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {

        if(password==this.passowrd){
            if(drawMoney>balance){
                return "Insufficient Money";
            }else{
                balance=balance-drawMoney;
                return "Money withdraw successfully . Remaining balance is "+balance;
            }
        }else{
            return "wrong password";
        }
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.passowrd==oldPassword){
            this.passowrd=newPassword;
            return "Password has been changed !";
        }else{
            return "Wrong password you have added !";
        }
    }

    @Override
    public double calculateTotalInterest(int years) {
        double  interest=balance*rateOfInterest*years/100;
        return interest;
    }
}
