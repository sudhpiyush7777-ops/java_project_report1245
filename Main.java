import java.util.Scanner;
class Item {
    String name;
    double price;
    int quantity;
    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
class Bill {
    Item[] items;
    public Bill(Item[] items) {
        this.items = items;
    }
    public void generateReceipt() {
        double total = 0;
        double tax;
        StringBuilder receipt = new StringBuilder();
        receipt.append("------ Grocery Bill ------\n");
        receipt.append("Item\tPrice\tQty\tTotal\n");
        for (Item item : items) {
            double itemTotal = item.getPrice() * item.getQuantity();
            total += itemTotal;
            receipt.append(item.getName()).append("\t")
                    .append(item.getPrice()).append("\t")
                    .append(item.getQuantity()).append("\t")
                    .append(itemTotal).append("\n");
        }
        tax = total * 0.05;
        receipt.append("\nTotal: ").append(total);
        receipt.append("\nTax (5%): ").append(tax);
        receipt.append("\nGrand Total: ").append(total + tax);
        System.out.println(receipt);
    }
}
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter item " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            items[i] = new Item(name, price, quantity);
        }
        Bill bill = new Bill(items);
        bill.generateReceipt();
        sc.close();
    }
}
