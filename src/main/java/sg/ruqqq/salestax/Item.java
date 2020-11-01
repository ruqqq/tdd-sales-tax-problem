package sg.ruqqq.salestax;

import lombok.Getter;

@Getter
public class Item {

    private final String name;
    private final boolean imported;
    private final int price;

    public Item(String name, int price, boolean imported) {
        this.name = name;
        this.imported = imported;
        this.price = price;
    }

    public int getTax() {
        if (isImported()) {
            return getImportedTax();
        }
        return getLocalTax();
    }

    private int getImportedTax() {
        return roundToNearestCents(((price * 231) / 200) - price);
    }

    private int getLocalTax() {
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
