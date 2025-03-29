package doarte.api.doador;

import doarte.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record DadosCadastrosDoador(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Date nascimento,
        @NotNull @Valid
        DadosEndereco endereco,
        @NotNull
        BigDecimal valor,
        @NotBlank
        String nomeProduto,
        @NotBlank
        String sobrenome,
        @NotBlank
        String cpf) {

}
