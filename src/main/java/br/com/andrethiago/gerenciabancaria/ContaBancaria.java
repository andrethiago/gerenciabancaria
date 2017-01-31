package br.com.andrethiago.gerenciabancaria;

import java.math.BigDecimal;

public class ContaBancaria {

	private String identificador;

	private BigDecimal saldo;

	public ContaBancaria(String identificador, BigDecimal saldo) {
		this.identificador = identificador;
		this.saldo = saldo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void debita(BigDecimal valor) {
		saldo.subtract(valor);
	}
	
	public void deposita(BigDecimal valor) {
		saldo.add(valor);
	}

	@Override
	public String toString() {
		return identificador;
	}
	
	

}
