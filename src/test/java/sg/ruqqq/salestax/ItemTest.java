package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void item_is_an_imported_product() {
        Item item = new Item("imported box of chocolate", 15.0);
        assertTrue(item.isImported());
    }

    @Test
    void item_is_not_an_imported_product() {
        Item item = new Item("box of chocolate", 15.0);
        assertFalse(item.isImported());
    }

    @Test
    void calculate_tax_of_local_product() {
        Item item = new Item("box of chocolate", 15.0);
        assertEquals(1.50, item.getTax());
    }

}
