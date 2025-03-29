package doarte.api.doacao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "doacao")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoacao;

    private Long idUsuario;
    private String email;
    private String nomeProduto;
    private BigDecimal valor;
    private String metodoPagamento;
    private String statusPagamento;

}