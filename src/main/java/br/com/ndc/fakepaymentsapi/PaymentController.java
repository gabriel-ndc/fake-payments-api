package br.com.ndc.fakepaymentsapi;

import br.com.ndc.fakepaymentsapi.dto.ExecutePaymentRequestDTO;
import br.com.ndc.fakepaymentsapi.dto.ExecutePaymentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class PaymentController {

    @Autowired
    private FakePaymentService fakePaymentService;

    @PostMapping("/api/execute-payment")
    public ResponseEntity<ExecutePaymentResponseDTO> executePayment(
            @RequestBody ExecutePaymentRequestDTO executePaymentRequestDTO) {
        var paymentStatus = fakePaymentService.executePayment();

        var response = new ExecutePaymentResponseDTO(
                executePaymentRequestDTO.paymentId(), paymentStatus.name().toLowerCase(Locale.ROOT));
        return ResponseEntity.ok(response);
    }
}
