package br.com.ndc.fakepaymentsapi.dto;

public record ExecutePaymentResponseDTO(
        Long paymentId,
        String status
) {
}
