package br.com.treinaweb.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<Empregado>();
		empregados.add(new Empregado(1, "João", 2000, "Produção"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "José", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));
		System.out.println(" ** LISTA DE EMPREGADOS **");
		/*for (Empregado emp : empregados) {
			System.out.println(emp.getNome());
		}*/
		empregados.stream().forEach(emp -> {
			System.out.println(emp.getNome());
		});
		/*double salarioTotal = 0;
		for (Empregado emp : empregados) {
			salarioTotal = salarioTotal + emp.getSalario();
		}*/
		double salarioTotal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();
		System.out.println("Salário total: R$ " + salarioTotal);
		
		Mensageiro mensageiro = (mensagem) -> 
			System.out.println("Mensagem da expressão lambda: " + mensagem);
		mensageiro.emitirMensagem("TreinaWeb");
		// ********************************
		// Consumer
		// Entra um parametro e nao retorna nada!
		System.out.println("Execução do consumer: ");
		Consumer<Empregado> consumer = (emp) -> {
			System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
		};
		consumer.accept(new Empregado(10, "TreinaWeb", 1000, "Educação"));
		// Functions
		System.out.println("Exemplo da function: ");
		Function<Empregado, Double> function = (emp) -> emp.getSalario() * 10;
		double novoSalario = function.apply(new Empregado(1000, "", 1, ""));
		System.out.println(novoSalario);
		// Binary Operator
		System.out.println("Execução do BinaryOperator: ");
		BinaryOperator<Empregado> binaryOperator = (emp1, emp2) -> new Empregado(-1, emp1.getNome() + emp2.getNome(), emp1.getSalario() + emp2.getSalario(), "Junção");
		Empregado novoEmpregado = binaryOperator.apply(new Empregado(0, "Treina", 1000, ""), new Empregado(0, "Web", 10000, ""));
		System.out.println(novoEmpregado.getNome() + ", R$ " + novoEmpregado.getSalario());
		
	}
	
}
