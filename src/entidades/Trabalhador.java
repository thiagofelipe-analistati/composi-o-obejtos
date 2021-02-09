package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enuns.Level;

public class Trabalhador {
	private String nome;
	private Level level;
	private Double salarioBase;
	
	
	// associação:
	private departamentos departamento;
	// inicia a lista, pq não pode ficar no construtor;
	private List<HorasContratos> contratos = new ArrayList();
	public Trabalhador() {
	
	}
	
	public Trabalhador(String nome, Level level, Double salarioBase, departamentos departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(departamentos departamento) {
		this.departamento = departamento;
	}

	public List<HorasContratos> getContratos() {
		return contratos;
	}

	public void addContrato(HorasContratos contrato) {
		contratos.add(contrato);
	}
	public void removeContrato(HorasContratos contrato) {
		contratos.remove(contrato);
	}
	
	public double income (int ano,int mes ) {
		double sum= salarioBase;
		// intancia o obejto do tipo data
		Calendar cal = Calendar.getInstance();
		for (HorasContratos c: contratos) {
			// recuperar a data do contrato
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = cal.get(Calendar.MONTH);
			
			if (ano == c_ano && mes == c_mes) {
				sum += c.totalHoras();
			}
		}
		return sum;
	}

}
