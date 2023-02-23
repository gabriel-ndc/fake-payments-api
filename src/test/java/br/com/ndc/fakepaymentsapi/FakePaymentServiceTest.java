package br.com.ndc.fakepaymentsapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FakePaymentServiceTest {

    @Autowired
    private FakePaymentService fakePaymentService;

    @Test
    public void shouldReturnSuccessTwoThirdsOfTheTime() {
        var numOfSuccesses = 0;
        var totalAttempts = 1000;

        for (var i = 0; i < totalAttempts; i++) {
            var result = fakePaymentService.executePayment();
            if (result.equals(PaymentStatus.SUCCESS))
                numOfSuccesses += 1;
        }

        Assertions.assertTrue(numOfSuccesses < 700);
        Assertions.assertTrue(numOfSuccesses > 600);
    }
}
