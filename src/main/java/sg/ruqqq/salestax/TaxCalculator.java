package sg.ruqqq.salestax;

public class TaxCalculator {
    public double calculateTax(Item item) {
        return (double) getTax(item) / 100;
    }

    public int getTax(Item item) {
        if (item.isImported()) {
            return getImportedTax(item.getPrice());
        }
        return getLocalTax(item.getPrice());
    }

    private int getImportedTax(int price) {
        return roundToNearestCents(((price * 231) / 200) - price);
    }

    private int getLocalTax(int price) {
        return roundToNearestCents(price / 10);
    }

    private int roundToNearestCents(int amount) {
        int cents = amount % 10;
        if (cents > 0 && cents < 5) {
            return amount - cents + 5;
        } else if (cents > 5) {
            return amount - cents + 10;
        } else {
            return amount;
        }
    }
}
