package doarte.api.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoIdentificadorDTO {
    @NotNull
    private String type;

    @NotNull
    private String number;

    public PagamentoIdentificadorDTO() {
    }

}