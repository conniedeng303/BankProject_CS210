public class CheckingAccount extends BankingAccount {
    private double overDraftLimit;


    public CheckingAccount(int accountNumber, String accountType, double balance, double overDraftLimit) {
        super(accountNumber, accountType, balance);
        this.overDraftLimit = overDraftLimit;
        this.setAccountType("Checking");
    }

    public double getOverDraftLimit() {
        return this.overDraftLimit;
    }

    @Override
    public boolean withdraw(double withdraw) {
        if (withdraw > this.overDraftLimit + this.getBalance()) {
            System.out.println("you have surpassed the overDraftLimit, FAILED.");
            return false;
        }
        else {
            setBalance(getBalance() - withdraw);
            System.out.println("Success! You have withdraw $ " + withdraw + " from your account");
            return true;
        }
    }
}

