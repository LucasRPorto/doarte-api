package doarte.api.controller;

import doarte.api.doador.DadosCadastrosDoador;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doador")
public class DoadorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastrosDoador dados){
        System.out.println(dados);
    }
}
