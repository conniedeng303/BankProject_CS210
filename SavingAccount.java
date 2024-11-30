public class SavingAccount extends BankingAccount {
    private static double interestRate;


    public SavingAccount(int accountNumber, String accountType, double balance) {
        super(accountNumber, accountType, balance);
        this.setAccountType("Savings");
    }

    public double calculateInterest() {
        double interest = getBalance() * interestRate;
        return interest;
    }

    public void applyInterest() {
        setBalance(getBalance() + calculateInterest());
    }


}
