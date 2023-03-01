package br.com.ndc.fakepaymentsapi;

import br.com.ndc.fakepaymentsapi.dto.ExecutePaymentRequestDTO;
import br.com.ndc.fakepaymentsapi.dto.ExecutePaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    private final FakePaymentService fakePaymentService;

    @PostMapping("/api/execute-payment")
    public ResponseEntity<ExecutePaymentResponseDTO> executePayment(
            @RequestBody ExecutePaymentRequestDTO executePaymentRequestDTO) {
        logger.info("POST /execute-payment - id {}", executePaymentRequestDTO.paymentId());

        var paymentStatus = fakePaymentService.executePayment();

        var response = new ExecutePaymentResponseDTO(
                executePaymentRequestDTO.paymentId(), paymentStatus.name().toLowerCase(Locale.ROOT));
        return ResponseEntity.ok(response);
    }
}
