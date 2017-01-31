package br.com.andrethiago.gerenciabancaria;

import java.math.BigDecimal;

import br.com.andrethiago.gerenciabancaria.exception.SaldoInsuficienteException;

public class TransferenciaBancariaService {

	private TransferenciaBancariaRepository repository = new TransferenciaBancariaRepository();

	public void transfere(ContaBancaria origem, ContaBancaria destino, BigDecimal valor) {
		validarTransferencia(origem, valor);
		origem.debita(valor);
		destino.deposita(valor);
		repository.salvar(origem);
		repository.salvar(destino);
	}

	private void validarTransferencia(ContaBancaria origem, BigDecimal valor) {
		if (origem.getSaldo().compareTo(valor) < 0) {
			throw new SaldoInsuficienteException(origem);
		}

	}

}
