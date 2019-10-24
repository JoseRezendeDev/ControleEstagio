package modelo;

import javax.persistence.Entity;

@Entity(name = "supervisor")
public class Supervisor extends Usuario {
	
	private String nome;

}
