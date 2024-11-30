import java.util.Scanner;

public class Bank {
    private static int nextAccountNumber = 0;
    public static BankingAccount[] accounts = new BankingAccount[11];
    
    public static void main(String[] args) {
        boolean running = true;
        Scanner keyboard = new Scanner(System.in);

        while (running == true) {
            System.out.println("Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display All Accounts");
            System.out.println("5. Exit");

            if (keyboard.hasNextInt()) {
                int option = keyboard.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("You have chosen to create account. Please enter only either checking or saving");
                        addAccount(accounts, keyboard);
                        displayAllAccounts(accounts);
                        break;

                    //I added a lot of nextLine methods to prevent random loops where the next
                    //method might take the previous inputs

                    case 2:
                        try {
                            System.out.println("How much do you want to deposit?");
                            double depositAmount = keyboard.nextDouble();
                            keyboard.nextLine();
                            System.out.println("Give me your account number:");
                            int accountNumberDeposit = keyboard.nextInt();
                            keyboard.nextLine();
                            Bank.deposit(accounts, accountNumberDeposit, depositAmount);
                        } catch (Exception e) {
                            System.out.println("Please enter a valid number for the deposit amount. FAILED.");
                            keyboard.nextLine();
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("How much do you want to withdraw?");
                            double withdrawAmount = keyboard.nextDouble();
                            keyboard.nextLine();
                            System.out.println("Give me your account number:");
                            int accountNumberWithdraw = keyboard.nextInt();
                            keyboard.nextLine();
                            Bank.withdraw(accounts, accountNumberWithdraw, withdrawAmount);
                        } catch (Exception e) { //i added an exception case because the menu would repeat itself because the input might receive a string input for example, which would cause an issue.
                            System.out.println("Please enter a valid number for the withdrawal amount. FAILED.");
                            keyboard.nextLine();
                        }
                        break;
                    case 4:
                        keyboard.nextLine();
                        System.out.println("Display all accounts");
                        Bank.displayAllAccounts(accounts);
                        break;
                    case 5:
                        keyboard.nextLine();
                        System.out.println("Exited.");
                        running = false;
                        break;
                    default:
                        keyboard.nextLine();
                        System.out.println("Please look at the choices again and choose a correct input.");
                        break;   
                    } 
            } else {
                    keyboard.nextLine();
                    System.out.println("Please enter one of the options choices.");
            }
        }
        keyboard.close();
        System.exit(0);
    }


    //adding account number
    private static int addAccount(BankingAccount[] accounts, Scanner keyboard) {
        //String accountType, BankingAccount account
        if (nextAccountNumber == 10) {
            System.out.println("Ran out of space for your account, or you entered wrong string");
            return -1;
        } 
        else {
            System.out.println("give me account type");
            keyboard.nextLine();
            String accountType = keyboard.nextLine();

            if (accountType.equals("saving")) {
                System.out.println("give me balance");
                double balance = keyboard.nextDouble();
                SavingAccount savings = new SavingAccount(nextAccountNumber,accountType,balance);
                accounts[nextAccountNumber] = savings;
                nextAccountNumber += 1;
            }
    
            else if (accountType.equals("checking")) {
                System.out.println("give me balance");
                double balance = keyboard.nextDouble();
                System.out.println("overDraftLimit");
                double overDraftLimit = keyboard.nextDouble();
                CheckingAccount checking = new CheckingAccount(nextAccountNumber,accountType,balance,overDraftLimit);
                accounts[nextAccountNumber] = checking;
                nextAccountNumber += 1;
            }
    
            else {
                System.out.println("You did not specify checking or savings, we exited this method");
            }

        }
        return nextAccountNumber - 1;
    }


    public static void deposit(BankingAccount[] accounts, int accountNumber, double depositAmount) {
        if (nextAccountNumber == 0) {
            System.out.println("THERE ARE NO ACCOUNTS TO DEPOSIT TO. FAILED");
        } else {
        accounts[accountNumber].deposit(depositAmount);
        displayAllAccounts(accounts);
        }
    }


    public static void withdraw(BankingAccount[] accounts, int accountNumber, double WithdrawAmount) {
        if (nextAccountNumber == 0) {
            System.out.println("THERE ARE NO ACCOUNTS TO WITHDRAW FROM. FAILED");
        } else {
        accounts[accountNumber].withdraw(WithdrawAmount);
        displayAllAccounts(accounts);
        }
    }

    public static void displayAllAccounts(BankingAccount[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                System.out.println("--------------------------------------");
                System.out.println("Account Name: " + accounts[i].getAccountNumber());
                System.out.println("Account Type: " + accounts[i].getAccountType());
                System.out.println("Account Total: " + accounts[i].getBalance());
                System.out.println("--------------------------------------");
            }
            else {
                break;
            }
        }
    }
}
// import java.util.Scanner;

// public class Bank {
//     private int nextAccountNumber = 0;
//     public BankingAccount[] accounts = new BankingAccount[10];
//     public static void main(String[] args) {
//         Bank Banking = new Bank();
//         Banking.runningMenu();

//         System.exit(0);
//     }

//     public void runningMenu() {
//         Scanner keyboard = new Scanner(System.in);
//         boolean running = true;
//         while (running) {
//             // nextAccountNumber += 1;
//             System.out.println("Menu");
//             System.out.println("1. Create Account");
//             System.out.println("2. Deposit");
//             System.out.println("3. Withdraw");
//             System.out.println("4. Display All Accounts");
//             System.out.println("5. Exit");

//             switch (keyboard.nextInt()) {
//                 case 1:
//                     System.out.println("You have chosen to create account.");
//                     addAccount(accounts, keyboard, nextAccountNumber);
//                     displayAllAccounts(accounts);
//                     break;

//                 case 2:
//                     System.out.println("How much do you want to deposit");
//                     double depositAmount = keyboard.nextDouble();
//                     System.out.println("give me your account number");
//                     int accountNumberDeposit = keyboard.nextInt();
//                     Bank.deposit(accounts, accountNumberDeposit, depositAmount);
//                     break;
//                 case 3:
//                     System.out.println("How much do you want to withdraw");
//                     double withdrawAmount = keyboard.nextDouble();
//                     System.out.println("give me your account number");
//                     int accountNumberWithdraw = keyboard.nextInt();
//                     Bank.withdraw(accounts,accountNumberWithdraw,withdrawAmount);
//                     break;
//                 case 4:
//                     System.out.println("Display all accounts");
//                     Bank.displayAllAccounts(accounts);
//                     break;
//                 case 5:
//                     System.out.println("Exited.");
//                     running = false;
//                     keyboard.close();
//                     break;
//                 default:
//                     System.out.println("Please look at the choices again and choose a correct input.");
//             }
//         }
//         keyboard.close();
//     }

//     //adding account number
//     private static int addAccount(BankingAccount[] accounts, Scanner keyboard, int nextAccountNumber) {
//         //String accountType, BankingAccount account
//         if (nextAccountNumber == 11) {
//             System.out.println("Ran out of space for your account, or you entered wrong string");
//             return -1;
//         } 
//         else {
//             System.out.println("give me account type");
//             keyboard.nextLine();
//             String accountType = keyboard.nextLine();
//             System.out.println("give me balance");
//             double balance = keyboard.nextDouble();
//             System.out.println("overDraftLimit");
//             double overDraftLimit = keyboard.nextDouble();

//             if (accountType.equals("saving")) {
//                 SavingAccount savings = new SavingAccount(nextAccountNumber,accountType,balance);
//                 accounts[nextAccountNumber] = savings;
//                 nextAccountNumber++;
//             }
    
//             else if (accountType.equals("checking")) {
//                 CheckingAccount checking = new CheckingAccount(nextAccountNumber,accountType,balance,overDraftLimit);
//                 accounts[nextAccountNumber] = checking;
//                 nextAccountNumber++;
//             }
    
//             else {
//                 System.out.println("You did not specify checking or savings, we exited this method");
//             }
//         }
//         return nextAccountNumber - 1;
//     }


//     public static void deposit(BankingAccount[] accounts, int accountNumber, double depositAmount) {
//         accounts[accountNumber].deposit(depositAmount);
//     }


//     public static void withdraw(BankingAccount[] accounts, int accountNumber, double WithdrawAmount) {
//         accounts[accountNumber].withdraw(WithdrawAmount);
//     }

//     public static void displayAllAccounts(BankingAccount[] accounts) {
//         for (int i = 0; i < accounts.length; i++) {
//             if (accounts[i] != null) {
//                 System.out.println("Account Name: " + accounts[i].getAccountNumber());
//                 System.out.println("Account Type: " + accounts[i].getAccountType());
//                 System.out.println("Account Total: " + accounts[i].getBalance());
//                 System.out.println("--------------------------------------");
//             }
//             else {
//                 break;
//             }
//         }
//     }
// }