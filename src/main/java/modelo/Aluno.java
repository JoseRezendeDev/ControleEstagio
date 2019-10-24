package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "aluno")
public class Aluno extends Usuario {
	
	private String nome;
	private String ra;
	
	@OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "aluno")
	private Curriculo curriculo; 
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estagio_id")
	private Estagio estagio;

}
