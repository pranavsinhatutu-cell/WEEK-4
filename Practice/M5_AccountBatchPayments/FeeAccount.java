public class FeeAccount {
    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }

    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAccount = (HostelFeeAccount) account;
            hostelAccount.pay(amount);
        } else {
            account.pay(amount);
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(), new HostelFeeAccount(),
            new FeeAccount(), new FeeAccount()
        };
        int hostelAccounts = 0;
        int dayScholarAccounts = 0;

        for (int i = 0; i < accounts.length; i++) {
            processPayment(accounts[i], 60000);
            if (accounts[i] instanceof HostelFeeAccount) {
                hostelAccounts++;
            } else {
                dayScholarAccounts++;
            }
        }
        System.out.println("Hostel accounts processed: " + hostelAccounts
                + " | Day-scholar accounts processed: " + dayScholarAccounts);
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}
