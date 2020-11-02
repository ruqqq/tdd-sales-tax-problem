package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCalculatorTest {
    TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    void calculate_tax_of_local_product() {
        Item item = new Item(1, "bottle of perfume", 1500, false, Item.Type.OTHERS);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(1.50, tax);
    }

    @Test
    void calculate_tax_of_imported_product() {
        Item item = new Item(1, "imported bottle of perfume", 1000, true, Item.Type.OTHERS);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(1.50, tax);
    }

    @Test
    void calculate_tax_of_imported_product_with_rounding_up() {
        Item item = new Item(1, "imported bottle of perfume", 1500, true, Item.Type.OTHERS);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(2.25, tax);
    }

    @Test
    void calculate_tax_of_imported_product_with_rounding_up_to_next_10_cents() {
        Item item = new Item(1, "imported bottle of perfume", 1530, true, Item.Type.OTHERS);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(2.35, tax);
    }

    @Test
    void calculate_tax_of_local_product_with_rounding_up_to_next_10_cents() {
        Item item = new Item(1, "bottle of perfume", 1899, false, Item.Type.OTHERS);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(1.9, tax);
    }

    @Test
    void exempted_from_basic_sales_tax_if_a_book() {
        Item item = new Item(1, "book", 1500, false, Item.Type.BOOK);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(0, tax);
    }

    @Test
    void exempted_from_basic_sales_tax_if_a_book_but_not_import_tax() {
        Item item = new Item(1, "book", 1500, true, Item.Type.BOOK);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(0.75, tax);
    }
}
