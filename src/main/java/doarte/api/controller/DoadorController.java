package doarte.api.controller;

import doarte.api.DTO.PixPagamentoResponseDTO;
import doarte.api.doador.*;
import doarte.api.doacao.Doacao;
import doarte.api.doacao.DoacaoRepository;
import doarte.api.service.MercadoPagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorRepository repository;

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping
    @Transactional
    public ResponseEntity<PixPagamentoResponseDTO> cadastrar(@RequestBody @Valid DadosCadastrosDoador dados) throws Exception {
        Doador doador = repository.save(new Doador(dados));
        PixPagamentoResponseDTO payment = mercadoPagoService.processPayment(dados);

        Doacao doacao = new Doacao();
        doacao.setIdUsuario(doador.getId());
        doacao.setEmail(dados.email());
        doacao.setNomeProduto(dados.nomeProduto());
        doacao.setValor(dados.valor());
        doacao.setMetodoPagamento("PIX");
        doacao.setStatusPagamento(payment.getStatus());

        doacaoRepository.save(doacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    @GetMapping
    public Page<DadosListagemDoador> listarDoador(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDoador::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaDoador dados) {
        var doador = repository.getReferenceById(dados.id());
        doador.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var doador = repository.getReferenceById(id);
        doador.excluir();
    }
}