package br.com.spring.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqName", sequenceName = "seqName", allocationSize = 1, initialValue = 1 )
public class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "serNome" )
	private long id;
	private String nome;
	private int idade;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

}
