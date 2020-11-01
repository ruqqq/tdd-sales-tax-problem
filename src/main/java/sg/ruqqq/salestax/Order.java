package sg.ruqqq.salestax;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> items;

    public Order(List<String> inputs) {
        this.items = new ArrayList<>();
        for (String input : inputs) {
            this.items.add(new Item(input));
        }
    }

    public List<String> getReceipt() {
        List<String> output = new ArrayList<>();
        double totalTax = 0;
        double totalPrice = 0;
        for (Item item : items) {
            output.add(item.getQty() + " " + item.getName() + ": " + String.format("%.2f", item.getPriceInDecimals()));
            totalTax += item.getTaxInDecimals();
            totalPrice += item.getPriceInDecimals();
        }
        output.add("Sales Tax: " + String.format("%.2f", totalTax));
        output.add("Total: " + String.format("%.2f", totalPrice + totalTax));
        return output;
    }
}
