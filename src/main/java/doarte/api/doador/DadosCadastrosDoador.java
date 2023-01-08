package doarte.api.doador;

import doarte.api.endereco.DadosEndereco;

import java.util.Date;

public record DadosCadastrosDoador(String nome, String email, String telefone, Date nascimento, DadosEndereco endereco) {
}
