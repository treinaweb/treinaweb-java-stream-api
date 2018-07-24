package br.com.treinaweb.java.streams;

public class MensageiroConsole implements Mensageiro {

	@Override
	public void emitirMensagem(String mensagem) {
		System.out.println("Mensagem: " + mensagem);
	}

}
