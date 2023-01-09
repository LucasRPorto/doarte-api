package doarte.api.doador;

public record DadosListagemDoador(String nome, String email, String telefone) {

    public DadosListagemDoador(Doador doador){
        this(doador.getNome(), doador.getEmail(), doador.getTelefone());
    }
}
