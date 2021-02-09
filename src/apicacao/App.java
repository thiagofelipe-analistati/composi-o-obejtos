package apicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.HorasContratos;
import entidades.Trabalhador;
import entidades.departamentos;
import entidades.enuns.Level;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub7
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Digite seu Departametno: ");
		String departamento = sc.nextLine();
		System.out.print("Digite os dados do trabalhaddor: ");
		System.out.print("Digite seu Nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Digite seu Salário Base: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, Level.valueOf(nivel), salarioBase, new departamentos(departamento));
		
		System.out.print("Quantos contratos?:");
		int n = sc.nextInt();
		for (int i=1; i<n; i++) {
			System.out.print("Entre com os dados do "+ i+ " Contrato: ");
			System.out.println("Entre com data (dd/mm/yyyyy): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.println("Duração do contrato: ");
			int horas = sc.nextInt();
			
			HorasContratos contrato = new HorasContratos(dataContrato, valorPorHora, horas);
			
			trabalhador.addContrato(contrato);
			
			
		}
		
		
		System.out.println();
		System.out.print("Digite o mês e ano: ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0,2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: "+ trabalhador.getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.println("Pelo pérido de " + mesEAno+ ": " + String.format("%.2f", trabalhador.income(mes,ano)));
		
		
		sc.close();

	}

}
