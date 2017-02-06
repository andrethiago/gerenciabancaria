package br.com.andrethiago.gerenciabancaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.andrethiago.gerenciabancaria.exception.SaldoInsuficienteException;

public class TransferenciaBancariaServiceTest {

	private TransferenciaBancariaService service = new TransferenciaBancariaService();

	@Rule
	public ExpectedException excecaoEsperada = ExpectedException.none();

	@Test(expected = SaldoInsuficienteException.class)
	public void transferenciaImpossivelSaldoInsuficienteDeveLancarExcecaoComExpected() {
		ContaBancaria origem = new ContaBancaria("CONTA-A", BigDecimal.valueOf(1500l));
		ContaBancaria destino = new ContaBancaria("CONTA-B", BigDecimal.valueOf(500l));

		service.transfere(origem, destino, BigDecimal.valueOf(2000l));
	}

	@Test
	public void transferenciaImpossivelSaldoInsuficienteDeveLancarExcecaoComTryCatch() {
		ContaBancaria origem = new ContaBancaria("CONTA-A", BigDecimal.valueOf(1500l));
		ContaBancaria destino = new ContaBancaria("CONTA-B", BigDecimal.valueOf(500l));

		try {
			service.transfere(origem, destino, BigDecimal.valueOf(2000l));
			fail("Falha. Uma exceção deve ser lançada!");
		} catch (SaldoInsuficienteException ex) {
			assertEquals(String.format(SaldoInsuficienteException.SALDO_INSUFICIENTE_MSG, origem), ex.getMessage());
		}
	}

	@Test
	public void transferenciaImpossivelSaldoInsuficienteDeveLancarExcecaoComTestRules() {
		ContaBancaria origem = new ContaBancaria("CONTA-A", BigDecimal.valueOf(1500l));
		ContaBancaria destino = new ContaBancaria("CONTA-B", BigDecimal.valueOf(500l));

		excecaoEsperada.expect(SaldoInsuficienteException.class);
		excecaoEsperada.expectMessage(String.format(SaldoInsuficienteException.SALDO_INSUFICIENTE_MSG, origem));

		service.transfere(origem, destino, BigDecimal.valueOf(2000l));
	}

}
