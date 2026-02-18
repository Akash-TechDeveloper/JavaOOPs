package Bank_Account;

public class SavingsAccount extends BankAccount{
    private static final double minAmount = 1000.0;
    public SavingsAccount(int accountNo, String holderName, double initialDeposit) {
        super(accountNo, holderName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < minAmount) {
            System.out.println(" Withdrawal denied: Overdraft limit exceeded (₹" + minAmount + ")");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: ₹" + amount);
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited: ₹" + amount);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account");
        System.out.println("Account No: " + getAccountNo());
        System.out.println("Name: " + getAccountHolderName());
        System.out.println("Balance: ₹" + getBalance());
    }
}


