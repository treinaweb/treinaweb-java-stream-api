package br.com.treinaweb.java.streams;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<Empregado>();
		empregados.add(new Empregado(1, "João", 2000, "Produção"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "José", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));
		
		System.out.println(" ** Funcionários que começam com J");
		Stream<Empregado> stream = empregados.stream().filter(emp -> {
			System.out.println(" ** Invocando o filter()");
			return emp.getNome().startsWith("J");
		});
		List<Empregado> empregadosComJ = stream.collect(Collectors.toList());
//		List<Empregado> empregadosComJ = empregados.stream()
//				.filter(emp -> emp.getNome().startsWith("J"))
//				.collect(Collectors.toList());
		empregadosComJ.forEach((emp) -> System.out.println(emp.getNome()));
		OptionalDouble menorSalario = empregadosComJ.stream().mapToDouble(emp -> emp.getSalario()).min();
		if (menorSalario.isPresent()) {
			System.out.println("Menor salário: R$ " + menorSalario.getAsDouble());
		}
		DoubleSummaryStatistics sumario = empregados.stream().collect(Collectors.summarizingDouble(Empregado::getSalario));
		System.out.println("Estatísticas dos salários:");
		System.out.println("Maior salário: R$ " + sumario.getMax());
		System.out.println("Menor salário: R$ " + sumario.getMin());
		System.out.println("Salário médio: R$ " + sumario.getAverage());
		System.out.println("Folha salarial: R$ " + sumario.getSum());
		List<String> nomesEmpregados = empregados.stream().map(emp -> emp.getNome()).collect(Collectors.toList());
		System.out.println(" ** Nomes dos empregados: ");
		nomesEmpregados.forEach(System.out::println);
		String nomesSeparadosPorVirgula = empregados.stream().map(Empregado::getNome)
				.reduce("Nomes dos empregados: ", (n1, n2) -> n1 + ", " + n2);
		System.out.println(nomesSeparadosPorVirgula);
		Map<String, List<Empregado>> dadosDepartamento = empregados.stream().collect(Collectors.groupingBy(Empregado::getDepartamento));
		System.out.println(" ** Empregados por departamento: ");
		dadosDepartamento.forEach((dep, emps) -> {
			System.out.println(" - " + dep + ", " + emps.size() + " empregados");
			emps.forEach(emp -> {
				System.out.println("	* " + emp.getNome());
			});
		});
		empregados.stream().forEach(emp -> {
			System.out.println(emp.getNome());
		});
		empregados.stream().forEach(System.out::println);
		
		PrintStream print = System.out;
		empregados.stream().forEach(emp -> {
			print.println(emp.getNome());
		});
		/*System.out.println(" ** LISTA DE EMPREGADOS **");
		for (Empregado emp : empregados) {
			System.out.println(emp.getNome());
		}
		empregados.stream().forEach(emp -> {
			System.out.println(emp.getNome());
		});
		double salarioTotal = 0;
		for (Empregado emp : empregados) {
			salarioTotal = salarioTotal + emp.getSalario();
		}
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
		// Predicate
		System.out.println("Execução do predicate: ");
		Predicate<Empregado> predicate = (emp) -> emp.getNome().endsWith("Web");
		Boolean terminaComWeb = predicate.test(new Empregado(0, "TreinaWeb", 0, ""));
		System.out.println(terminaComWeb);
		// Supplier
		System.out.println("Execução do supplier: ");
		Supplier<Empregado> supplier = () -> new Empregado(new Random().nextInt(), "TreinaWeb", 0, "");
		Empregado emp1 = supplier.get();
		System.out.println(emp1.getId());
		Empregado emp2 = supplier.get();
		System.out.println(emp2.getId());*/		
	}
	
}
