package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCalculatorTest {
    TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    void calculate_tax_of_local_product() {
        Item item = new Item(1, "box of chocolate", 1500, false);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(1.50, tax);
    }

    @Test
    void calculate_tax_of_imported_product() {
        Item item = new Item(1, "imported box of chocolate", 1000, true);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(1.55, tax);
    }

    @Test
    void calculate_tax_of_imported_product_with_rounding_up() {
        Item item = new Item(1, "imported box of chocolate", 1500, true);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(2.35, tax);
    }

    @Test
    void calculate_tax_of_imported_product_with_rounding_up_to_next_10_cents() {
        Item item = new Item(1, "imported box of chocolate", 1530, true);
        double tax = taxCalculator.calculateTax(item);
        assertEquals(2.40, tax);
    }
}
