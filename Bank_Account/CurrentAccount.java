package Bank_Account;

public class  CurrentAccount extends BankAccount {
    private static final double minAmount = 100.0;
    public CurrentAccount(int accountNo, String AccountHolderName, double balance) {
        super(accountNo, AccountHolderName, balance);
    }
        @Override
        public void withdraw(double amount) {
            if (getBalance() - amount < minAmount) {
                System.out.println("Withdrawal denied: Overdraft limit exceeded (₹" + minAmount + ")");
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
            System.out.println("Current Account");
            System.out.println("Account No: " + getAccountNo());
            System.out.println("Name: " + getAccountHolderName());
            System.out.println("Balance: ₹" + getBalance());
        }
}
