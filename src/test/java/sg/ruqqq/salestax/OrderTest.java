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
                "Sales Tax: 1.25",
                "Total: 13.74"
        ), receipt);
    }
}
