package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    void should_output_receipt_for_one_item() {
        Order order = new Order(Collections.singletonList(
                "1 book at 12.49"
        ));

        List<String> receipt = order.getReceipt();

        assertEquals(Arrays.asList(
                "1 book: 12.49",
                "Sales Taxes: 0.00",
                "Total: 12.49"
        ), receipt);
    }

    @Test
    void should_output_price_rounded_up() {
        Order order = new Order(Collections.singletonList(
                "1 bottle of perfume at 18.99"
        ));

        List<String> receipt = order.getReceipt();

        assertEquals(Arrays.asList(
                "1 bottle of perfume: 20.89",
                "Sales Taxes: 1.90",
                "Total: 20.89"
        ), receipt);
    }

    @Test
    void scenario_1() {
        Order order = new Order(Arrays.asList(
                "1 book at 12.49",
                "1 music CD at 14.99",
                "1 chocolate bar at 0.85"
        ));

        List<String> receipt = order.getReceipt();

        assertEquals(Arrays.asList(
                "1 book: 12.49",
                "1 music CD: 16.49",
                "1 chocolate bar: 0.85",
                "Sales Taxes: 1.50",
                "Total: 29.83"
        ), receipt);
    }

    @Test
    void scenario_2() {
        Order order = new Order(Arrays.asList(
                "1 imported box of chocolates at 10.00",
                "1 imported bottle of perfume at 47.50"
        ));

        List<String> receipt = order.getReceipt();

        assertEquals(Arrays.asList(
                "1 imported box of chocolates: 10.50",
                "1 imported bottle of perfume: 54.65",
                "Sales Taxes: 7.65",
                "Total: 65.15"
        ), receipt);
    }

    @Test
    void scenario_3() {
        Order order = new Order(Arrays.asList(
                "1 imported bottle of perfume at 27.99",
                "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25"
        ));

        List<String> receipt = order.getReceipt();

        assertEquals(Arrays.asList(
                "1 imported bottle of perfume: 32.19",
                "1 bottle of perfume: 20.89",
                "1 packet of headache pills: 9.75",
                "1 imported box of chocolates: 11.85",
                "Sales Taxes: 6.70",
                "Total: 74.68"
        ), receipt);
    }
}
