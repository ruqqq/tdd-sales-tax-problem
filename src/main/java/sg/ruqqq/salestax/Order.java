package sg.ruqqq.salestax;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final TaxCalculator taxCalculator;
    private final List<Item> items;

    public Order(List<String> inputs) {
        this.taxCalculator = new TaxCalculator();
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
            double tax = taxCalculator.calculateTax(item);
            output.add(item.getQty() + (item.isImported() ? " imported " : " ") + item.getName() + ": " + String.format("%.2f", item.getPriceInDecimals() + tax));
            totalTax += tax;
            totalPrice += item.getPriceInDecimals();
        }
        output.add("Sales Taxes: " + String.format("%.2f", totalTax));
        output.add("Total: " + String.format("%.2f", totalPrice + totalTax));
        return output;
    }
}
