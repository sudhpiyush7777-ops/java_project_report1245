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
            receipt.append(item.getName() + "\t"
                    + item.getPrice() + "\t"
                    + item.getQuantity() + "\t"
                    + itemTotal + "\n");
        }
        tax = total * 0.05;
        receipt.append("\nTotal: " + total + "\n");
        receipt.append("Tax (5%): " + tax + "\n");
        receipt.append("Grand Total: " + (total + tax) + "\n");
        System.out.println(receipt.toString());
    }
}
public class Main {
    public static void main(String[] args) {
        Item[] items = {
            new Item("Rice", 50, 2),
            new Item("Milk", 30, 3),
        };
        Bill bill = new Bill(items);
        bill.generateReceipt();
    }
}
