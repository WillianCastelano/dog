package com.dog.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PessoaResponse {
    private Long id;
    private String nome;
    private int idade;
}
