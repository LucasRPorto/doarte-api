package doarte.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco dados) {
        this.cep= dados.cep();
        this.rua=dados.rua();
        this.bairro= dados.bairro();
        this.cidade=dados.cidade();
        this.uf=dados.uf();
        this.numero= dados.numero();
        this.complemento=dados.complemento();
    }
}
