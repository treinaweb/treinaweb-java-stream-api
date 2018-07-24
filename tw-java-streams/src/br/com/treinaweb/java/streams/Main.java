package br.com.treinaweb.java.streams;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<Empregado>();
		empregados.add(new Empregado(1, "João", 2000, "Produção"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "José", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));
		System.out.println(" ** LISTA DE EMPREGADOS **");
		for (Empregado emp : empregados) {
			System.out.println(emp.getNome());
		}
		double salarioTotal = 0;
		for (Empregado emp : empregados) {
			salarioTotal = salarioTotal + emp.getSalario();
		}
		System.out.println("Salário total: R$ " + salarioTotal);
	}
	
}
