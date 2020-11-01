package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void item_is_an_imported_product() {
        Item item = new Item("imported box of chocolate", 1500, true);
        assertTrue(item.isImported());
    }

    @Test
    void item_is_not_an_imported_product() {
        Item item = new Item("box of chocolate", 1500, false);
        assertFalse(item.isImported());
    }

    @Test
    void calculate_tax_of_local_product() {
        Item item = new Item("box of chocolate", 1500, false);
        assertEquals(150, item.getTax());
    }

    @Test
    void calculate_tax_of_imported_product() {
        Item item = new Item("imported box of chocolate", 1000, true);
        assertEquals(155, item.getTax());
    }

    @Test
    void calculate_tax_of_imported_product_with_rounding_up() {
        Item item = new Item("imported box of chocolate", 1500, true);
        assertEquals(235, item.getTax());
    }

    @Test
    void calculate_tax_of_imported_product_with_rounding_up_to_next_10_cents() {
        Item item = new Item("imported box of chocolate", 1530, true);
        assertEquals(240, item.getTax());
    }
}
