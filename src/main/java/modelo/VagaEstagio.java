package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VagaEstagio {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String descricao;
	private String requisitosObrigatorios;
	private String requisitosDesejaveis;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRequisitosObrigatorios() {
		return requisitosObrigatorios;
	}
	public void setRequisitosObrigatorios(String requisitosObrigatorios) {
		this.requisitosObrigatorios = requisitosObrigatorios;
	}
	public String getRequisitosDesejaveis() {
		return requisitosDesejaveis;
	}
	public void setRequisitosDesejaveis(String requisitosDesejaveis) {
		this.requisitosDesejaveis = requisitosDesejaveis;
	}

}
