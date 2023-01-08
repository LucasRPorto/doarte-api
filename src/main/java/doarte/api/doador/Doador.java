package doarte.api.doador;

import doarte.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name="doador")
@Entity(name="doador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Doador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Date nascimento;

    @Embedded
    private Endereco endereco;

    public Doador(DadosCadastrosDoador dados) {
        this.nome = dados.nome();
        this.email= dados.email();
        this.telefone= dados.telefone();
        this.nascimento=dados.nascimento();
        this.endereco=new Endereco(dados.endereco());
    }
}
