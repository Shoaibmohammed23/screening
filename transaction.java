import java.util.ArrayList;
import java.util.List;

class Transaction {
    private double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class Customer {
    private String customerId;
    private List<Transaction> transactions;

    public Customer(String customerId) {
        this.customerId = customerId;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

public class RewardPointsCalculator {
    public static int calculateRewardPoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += 2 * (int) (amount - 100);
        }
        if (amount > 50) {
            points += (int) (amount - 50);
        }
        return points;
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Cust123");
        customer1.addTransaction(new Transaction(120));
        customer1.addTransaction(new Transaction(80));
        customer1.addTransaction(new Transaction(60));

        Customer customer2 = new Customer("Cust456");
        customer2.addTransaction(new Transaction(90));
        customer2.addTransaction(new Transaction(70));

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        // Calculate and print reward points for each customer
        for (Customer customer : customers) {
            int totalPoints = 0;
            System.out.println("Customer ID: " + customer.getCustomerId());
            for (Transaction transaction : customer.getTransactions()) {
                int points = calculateRewardPoints(transaction.getAmount());
                System.out.println("Transaction amount: $" + transaction.getAmount() + ", Reward Points: " + points);
                totalPoints += points;
            }
            System.out.println("Total Reward Points: " + totalPoints);
            System.out.println("--------------");
        }
    }
}


