package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void item_is_an_imported_product() {
        Item item = new Item(1, "imported box of chocolate", 1500, true, Item.Type.OTHERS);
        assertTrue(item.isImported());
    }

    @Test
    void item_is_not_an_imported_product() {
        Item item = new Item(1, "box of chocolate", 1500, false, Item.Type.OTHERS);
        assertFalse(item.isImported());
    }

    @Test
    void parse_string_to_item() {
        Item item = new Item("1 box of imported chocolates at 10.00");
        assertEquals(1, item.getQty());
        assertEquals("box of chocolates", item.getName());
        assertTrue(item.isImported());
        assertEquals(1000, item.getPrice());
    }

    @Test
    void return_price_in_double() {
        Item item = new Item(1, "imported box of chocolate", 1530, true, Item.Type.OTHERS);
        assertEquals(15.30, item.getPriceInDecimals());
    }

    @Test
    void parse_price_without_loss_of_information() {
        Item item = new Item("1 imported box of chocolates at 18.99");
        assertEquals(18.99, item.getPriceInDecimals());
    }

    @Test
    void parse_item_as_others() {
        Item item = new Item("1 imported bottle of perfume at 10.00");
        assertEquals(Item.Type.OTHERS, item.getType());
    }

    @Test
    void parse_item_as_food() {
        Item item = new Item("1 imported box of chocolates at 10.00");
        assertEquals(Item.Type.FOOD, item.getType());
    }

    @Test
    void parse_item_as_book() {
        Item item = new Item("1 book at 10.00");
        assertEquals(Item.Type.BOOK, item.getType());
    }

    @Test
    void parse_item_as_medical_product() {
        Item item = new Item("1 headache pills at 10.00");
        assertEquals(Item.Type.MEDICAL_PRODUCT, item.getType());
    }
}
