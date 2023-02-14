package doarte.api.controller;

import doarte.api.doador.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping // Não precisa de transactional pois estou apenas listando
    public Page<DadosListagemDoador> listarDoador(@PageableDefault(sort = {"nome"})Pageable paginacao) {
        // Convertendo lista de doador para lista de dados listagem doador (DTO) e motando esquema de paginação
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDoador::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaDoador dados){
        var doador = repository.getReferenceById(dados.id());
        doador.atualizarInformacoes(dados);
    }

    //Realizando a exclusão física do meu donator no meu db
    @DeleteMapping("/{id}") // Path serve para informar que o id é patâmetro do método delete
    @Transactional
    public void excluir(@PathVariable Long id){
        var doador = repository.getReferenceById(id);
        doador.excluir();
    }

}
