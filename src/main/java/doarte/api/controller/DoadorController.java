package doarte.api.controller;

import doarte.api.doador.DadosCadastrosDoador;
import doarte.api.doador.DadosListagemDoador;
import doarte.api.doador.Doador;
import doarte.api.doador.DoadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import  java.util.List;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrosDoador dados){

        repository.save(new Doador(dados));
    }

    @GetMapping
    public List<DadosListagemDoador> listarDoador() {
        // Convertendo lista de doador para lista de dados listagem doador (DTO)
        return repository.findAll().stream().map(DadosListagemDoador::new).toList();
    }

}
