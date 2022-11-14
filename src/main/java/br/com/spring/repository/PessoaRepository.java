package br.com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.model.Pessoa;



/*  O repository é dado por classes de  intercaces a classe da interface" exteds  da calsse JpaReposity e a classe JPA
 *  recebe o nome da classe modelo  no banco de dados e referencia o pito de dados da chave pirmaria no banco de dados." */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
