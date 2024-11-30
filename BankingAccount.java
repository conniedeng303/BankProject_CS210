abstract class BankingAccount {
    private int accountNumber;
    private String accountType;
    private double balance;

    public BankingAccount(int accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean deposit(double depositValue) {
        if (depositValue > 0) {
            System.out.println("deposit of " + depositValue + " has been added");
            this.balance = this.balance + depositValue;
            return true;

        } else {
            System.out.println("please give a positive deposit number");
            return false;
        }
    }

    public boolean withdraw(double withdrawValue) {
        if (withdrawValue > 0) {
            if (this.balance >= withdrawValue) {
                this.balance = this.balance - withdrawValue;
                return true;
            
            } else {
                System.out.println("YOUR WITHDRAWAL AMOUNT IS LARGER THAN YOUR BALANCE.");
                return false;
            }
        } else {
            System.out.println("please give a positive withdrawal number");
            return false;
        }
    }
}