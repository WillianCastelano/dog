package com.dog.controller;


import com.dog.DTO.PessoaRequest;
import com.dog.DTO.PessoaResponse;
import com.dog.modelo.Pessoa;
import com.dog.repository.PessoaRepository;
import com.dog.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/faixa-etaria")
    public List<PessoaResponse> buscarPorFaixaEtaria(
            @RequestParam int idadeMin,
            @RequestParam int idadeMax) {
        return pessoaService.buscarPorFaixaEtaria(idadeMin, idadeMax)
                .stream()
                .map(p -> new PessoaResponse(p.getId(), p.getNome(), p.getIdade()))
                .toList();

    }

    @PostMapping
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaService.salvar(pessoaRequest);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa (@PathVariable long id) {
        Pessoa pessoa = pessoaService.buscarPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoaAtualizada = pessoaService.atualizar(id, pessoaRequest);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        String menssagem = pessoaService.deletar(id);
        return ResponseEntity.ok(menssagem);
    }


}
