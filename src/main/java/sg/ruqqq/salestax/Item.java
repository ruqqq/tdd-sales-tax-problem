package sg.ruqqq.salestax;

import lombok.Getter;

@Getter
public class Item {

    private final String name;
    private final boolean imported;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.imported = name.startsWith("imported");
        this.price = price;
    }

    public double getTax() {
        return price * 0.1;
    }
}
