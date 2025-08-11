package com.dog.repository;

import com.dog.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByIdadeBetween(int idadeMin, int idadeMax);
    //O findByIdadeBetween já é um método pronto que o Spring Data entende e converte em SQL do tipo
    //SELECT * FROM pessoa WHERE idade BETWEEN ? AND ?.


}
