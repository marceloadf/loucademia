package br.com.loucademia.domain.aluno;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone{
	
	@Column(name = "CELULAR_DD", nullable = false, length = 2)
	private Integer ddCelular;
	
	@Column(name = "NUMERO_CELULAR", nullable = false, length = 9)
	private Integer numeroCelular;
	
	@Column(name = "FIXO_DD", nullable = true, length = 2)
	private Integer ddFixo;
	
	@Column(name = "FIXO_CELULAR", nullable = true, length = 9)
	private Integer numeroFixo;

	public Integer getDdCelular() {
		return ddCelular;
	}

	public void setDdCelular(Integer ddCelular) {
		this.ddCelular = ddCelular;
	}

	public Integer getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Integer getDdFixo() {
		return ddFixo;
	}

	public void setDdFixo(Integer ddFixo) {
		this.ddFixo = ddFixo;
	}

	public Integer getNumeroFixo() {
		return numeroFixo;
	}

	public void setNumeroFixo(Integer numeroFixo) {
		this.numeroFixo = numeroFixo;
	}

	@Override
	public String toString() {
		return "Telefone [ddCelular=" + ddCelular + ", numeroCelular=" + numeroCelular + ", ddFixo=" + ddFixo
				+ ", numeroFixo=" + numeroFixo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddCelular == null) ? 0 : ddCelular.hashCode());
		result = prime * result + ((ddFixo == null) ? 0 : ddFixo.hashCode());
		result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
		result = prime * result + ((numeroFixo == null) ? 0 : numeroFixo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (ddCelular == null) {
			if (other.ddCelular != null)
				return false;
		} else if (!ddCelular.equals(other.ddCelular))
			return false;
		if (ddFixo == null) {
			if (other.ddFixo != null)
				return false;
		} else if (!ddFixo.equals(other.ddFixo))
			return false;
		if (numeroCelular == null) {
			if (other.numeroCelular != null)
				return false;
		} else if (!numeroCelular.equals(other.numeroCelular))
			return false;
		if (numeroFixo == null) {
			if (other.numeroFixo != null)
				return false;
		} else if (!numeroFixo.equals(other.numeroFixo))
			return false;
		return true;
	}	

}
