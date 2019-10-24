package modelo;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "estagio")
public class Estagio extends VagaEstagio {
	 
	
	private ZonedDateTime dataInicio;
	private ZonedDateTime dataFim;
	private int duracao;
	
	@OneToMany(cascade = CascadeType.ALL )
	private List<Relatorio> relatorios;
	
	@OneToOne(fetch = FetchType.EAGER,
            mappedBy = "estafio")
	private Aluno aluno;
		
	public ZonedDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(ZonedDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public ZonedDateTime getDataFim() {
		return dataFim;
	}
	public void setDataFim(ZonedDateTime dataFim) {
		this.dataFim = dataFim;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public List<Relatorio> getRelatorios() {
		return relatorios;
	}
	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}


}
