package br.com.spring.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.spring.model.Pessoa;
import br.com.spring.repository.PessoaRepository;



@RestController
public class Testa {
	
	
	@Autowired
	 private PessoaRepository rep;
Pessoa pessoa = new Pessoa();


	@RequestMapping(value = "/testa/{nome}", method =  RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String inpuText(@PathVariable String nome) {
		

		return " nome = " + nome;
	}
	
	/*cadsatra no banco de dados*/
	@PostMapping( value ="salvar") 
	@ResponseBody
	 public ResponseEntity<Pessoa> salvar(@RequestBody  Pessoa pessoa){
		 
		 Pessoa  pes = rep.save(pessoa);
		 	
		 
		 return  new ResponseEntity<Pessoa>(pes, HttpStatus.CREATED);
	 }
	
	
	
/*chamanad de listas */
	@GetMapping ( value = "listar")
	@ResponseBody
public ResponseEntity<List<Pessoa>> listPessoa(){
	
	List<Pessoa> pessoas = rep.findAll();
	
	
	return  new ResponseEntity<List<Pessoa>>(pessoas,HttpStatus.OK);
	
	
	
}
	
	/*deleta dados cadsatrados no banco de dados */
	@DeleteMapping( value ="delete") 
	@ResponseBody
	 public ResponseEntity<String> deletar(@RequestParam Long id_pessoa){/*@RequesteParam. Faz uso dos dados na  da base de dados , ele tem acesso a cada informação e a acada dado contido no BD*/
		 rep.deleteById(id_pessoa);
		 
		 
		 return  new ResponseEntity<String>("A pagado com suscesso do BD!!!", HttpStatus.OK);
	 }
	
	
	/*faz uma busca no banco de dados*/
	@GetMapping( value ="buscar") 
	@ResponseBody
	 public ResponseEntity<Pessoa> buscar(@RequestParam(name = "id_pessoa")  Long id_pessoa){/*@RequesteParam. Faz uso dos dados na  da base de dados , ele tem acesso a cada informação e a acada dado contido no BD*/
		 Pessoa pessoa = rep.findById(id_pessoa).get();
		 
		 
		 return  new ResponseEntity<Pessoa>(pessoa,HttpStatus.OK);
	 }
	
	/*faz uma busca no banco de dados*/
	@GetMapping( value ="atualizar") 
	@ResponseBody
	 public ResponseEntity<?> atualizar(@RequestBody  Pessoa pessoa){/*@RequesteParam. Faz uso dos dados na  da base de dados , ele tem acesso a cada informação e a acada dado contido no BD*/
		 if (pessoa.getNome() == null )
		 {
				return  new ResponseEntity<String>("O Id  da pessoa precisa ser informado!!!",HttpStatus.OK);
			}
			 
			 Pessoa pes = rep.saveAndFlush(pessoa);
		 
		  return  new ResponseEntity<Pessoa>(pes,HttpStatus.OK);
	 }
	
	

}
