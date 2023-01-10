package doarte.api.doador;

public record DadosListagemDoador(Long id, String nome, String email, String telefone) {

    public DadosListagemDoador(Doador doador){
        this(doador.getId(),doador.getNome(), doador.getEmail(), doador.getTelefone());
    }
}
