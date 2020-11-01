package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void item_is_an_imported_product() {
        Item item = new Item("imported box of chocolate");
        assertTrue(item.isImported());
    }

    @Test
    void item_is_not_an_imported_product() {
        Item item = new Item("box of chocolate");
        assertFalse(item.isImported());
    }

}
