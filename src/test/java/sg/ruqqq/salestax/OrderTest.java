package sg.ruqqq.salestax;

import org.junit.jupiter.api.Test;

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

        assertEquals(3, receipt.size());
        assertEquals("1 book: 12.49", receipt.get(0));
        assertEquals("Sales Tax: 1.25", receipt.get(1));
        assertEquals("Total: 13.74", receipt.get(2));
    }

}
