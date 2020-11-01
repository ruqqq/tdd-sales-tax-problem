package sg.ruqqq.salestax;

import lombok.Getter;

@Getter
public class Item {

    private final String name;
    private final boolean imported;

    public Item(String name) {
        this.name = name;
        this.imported = name.startsWith("imported");
    }
}
