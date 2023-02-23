package br.com.ndc.fakepaymentsapi;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePaymentService {

    public PaymentStatus executePayment() {
        // returns failure approx. 1/3 of the time
        var generator = new Random();

        if (generator.nextInt(3) == 0) {
            return PaymentStatus.FAILURE;
        } else {
            return PaymentStatus.SUCCESS;
        }
    }
}
