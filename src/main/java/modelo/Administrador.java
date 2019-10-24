package modelo;

import javax.persistence.Entity;

@Entity(name = "administrador")
public class Administrador extends Usuario {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
