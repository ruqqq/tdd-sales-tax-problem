package sg.ruqqq.salestax;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Item {

    private final int qty;
    private final String name;
    private final boolean imported;
    private final int price;
    private final Type type;

    public Item(int qty, String name, int price, boolean imported, Type type) {
        this.qty = qty;
        this.name = name;
        this.imported = imported;
        this.price = price;
        this.type = type;
    }

    public Item(String lineItem) {
        String[] splitLine = lineItem.split(" ");
        String qtyString = splitLine[0];
        String priceString = splitLine[splitLine.length - 1];
        this.qty = Integer.parseInt(qtyString);
        this.name = String.join(" ", Arrays.asList(splitLine).subList(1, splitLine.length - 2));
        this.imported = name.startsWith("imported");
        this.price = (int) (Double.parseDouble(priceString) * 100);
        this.type = Type.OTHERS;
    }

    public double getPriceInDecimals() {
        return (double) price / 100;
    }

    public enum Type {
        BOOK,
        FOOD,
        MEDICAL_PRODUCTS,
        OTHERS,
    }
}
