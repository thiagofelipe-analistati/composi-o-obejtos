package entidades;

import java.util.Date;

public class HorasContratos {
	private Date data;
	private Double ValorPorHoras;
	private Integer horas;
	public HorasContratos() {
	
	}
	public HorasContratos(Date data, Double valorPorHoras, Integer horas) {
		this.data = data;
		this.ValorPorHoras = valorPorHoras;
		this.horas = horas;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorPorHoras() {
		return ValorPorHoras;
	}
	public void setValorPorHoras(double valorPorHoras) {
		this.ValorPorHoras = valorPorHoras;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public double totalHoras() {
		return ValorPorHoras* horas;
	}
}
