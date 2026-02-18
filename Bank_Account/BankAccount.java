package Bank_Account;

public abstract class BankAccount {
    private int accountNo;
    private String accountHolderName;
    private double balance;
    public BankAccount(int accountNo,String accountHolderName ,double balance){
        this.accountNo=accountNo;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayAccountDetails();

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
