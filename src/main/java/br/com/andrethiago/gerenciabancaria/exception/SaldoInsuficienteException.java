package br.com.andrethiago.gerenciabancaria.exception;

import br.com.andrethiago.gerenciabancaria.ContaBancaria;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = -7059128206189012099L;
	
	public static final String SALDO_INSUFICIENTE_MSG = "A conta %s não possui saldo suficiente";

	public SaldoInsuficienteException(ContaBancaria destino) {
		super(String.format(SALDO_INSUFICIENTE_MSG, destino.toString()));
		
	}

}
