package doarte.api.service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import doarte.api.DTO.PixPagamentoResponseDTO;
import doarte.api.doador.DadosCadastrosDoador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MercadoPagoService {
    @Value("${mercadopago.access.token}")
    private String mercadoPagoAccessToken;

    public PixPagamentoResponseDTO processPayment(DadosCadastrosDoador dados) throws MPException, MPApiException {

            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

            PaymentClient paymentClient = new PaymentClient();

            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(dados.valor().toString()))
                            .description(dados.nomeProduto())
                            .paymentMethodId("pix")
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(dados.email())
                                            .firstName(dados.nome())
                                            .lastName(dados.sobrenome())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type("CPF")
                                                            .number(dados.cpf())
                                                            .build())
                                            .build())
                            .build();

            Payment createdPayment = paymentClient.create(paymentCreateRequest);

            return new PixPagamentoResponseDTO(
                    createdPayment.getId(),
                    String.valueOf(createdPayment.getStatus()),
                    createdPayment.getStatusDetail(),
                    createdPayment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                    createdPayment.getPointOfInteraction().getTransactionData().getQrCode());
    }
}
