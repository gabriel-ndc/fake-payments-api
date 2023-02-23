package br.com.ndc.fakepaymentsapi;

import br.com.ndc.fakepaymentsapi.dto.ExecutePaymentRequestDTO;
import br.com.ndc.fakepaymentsapi.dto.ExecutePaymentResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void shouldReturnIfSuccessfulOrFailure() {
        var body = new ExecutePaymentRequestDTO(123L);

        var responseBody = WebTestClient
                .bindToServer()
                    .baseUrl("http://localhost:" + port)
                    .build()
                    .post()
                    .uri("/execute-payment")
                    .bodyValue(body)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(ExecutePaymentResponseDTO.class).returnResult()
                .getResponseBody();

        Assertions.assertEquals(123L, responseBody.paymentId());
        Assertions.assertTrue(responseBody.status().contentEquals("success")
                || responseBody.status().contentEquals("failure"));
    }
}
