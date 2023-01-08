package doarte.api.controller;

import doarte.api.doador.DadosCadastrosDoador;
import doarte.api.doador.Doador;
import doarte.api.doador.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doador")
public class DoadorController {

    @Autowired
    private DoadorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastrosDoador dados){
        repository.save(new Doador(dados));
    }
}
