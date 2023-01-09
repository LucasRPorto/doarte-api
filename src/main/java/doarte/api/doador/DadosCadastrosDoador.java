package doarte.api.doador;

import doarte.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

public record DadosCadastrosDoador(
        @NotBlank //Não pode ser null nem em branco. Necessário colocar o valid no controller e nos dtos
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Date nascimento,
        @NotNull @Valid
        DadosEndereco endereco) {

}
