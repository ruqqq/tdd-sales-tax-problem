package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void item_is_an_imported_product() {
        Item item = new Item(1, "imported box of chocolate", 1500, true);
        assertTrue(item.isImported());
    }

    @Test
    void item_is_not_an_imported_product() {
        Item item = new Item(1, "box of chocolate", 1500, false);
        assertFalse(item.isImported());
    }

    @Test
    void parse_string_to_item() {
        Item item = new Item("1 imported box of chocolates at 10.00");
        assertEquals(1, item.getQty());
        assertEquals("imported box of chocolates", item.getName());
        assertEquals(1000, item.getPrice());
    }

    @Test
    void return_price_in_double() {
        Item item = new Item(1, "imported box of chocolate", 1530, true);
        assertEquals(15.30, item.getPriceInDecimals());
    }

}
