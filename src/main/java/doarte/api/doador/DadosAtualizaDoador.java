package doarte.api.doador;

import doarte.api.endereco.DadosEndereco;
import doarte.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAtualizaDoador(
        @NotNull
        Long id,

        String nome,
        String telefone,

        String email,

        Date nascimento,

        DadosEndereco endereco) {
}
