package sg.ruqqq.salestax;

public class TaxCalculator {
    public double calculateTax(Item item) {
        return (double) getTax(item) / 100;
    }

    public int getTax(Item item) {
        int tax = getBasicSalesTax(item.getPrice(), item.getType());
        if (item.isImported()) {
            return tax + getImportTax(item.getPrice());
        }
        return tax;
    }

    private int getImportTax(int price) {
        return roundToNearestCents(price * 21 / 20 - price);
    }

    private int getBasicSalesTax(int price, Item.Type itemType) {
        if (itemType.equals(Item.Type.BOOK) || itemType.equals(Item.Type.FOOD) || itemType.equals(Item.Type.MEDICAL_PRODUCT)) {
            return 0;
        }
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
