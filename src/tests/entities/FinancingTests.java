package tests.entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {
	/*
	 * Implementação com padrão AAA:
	 * Arrange: instancie os objetos necessários
	 * Act: execute as ações necessárias
	 * Assert: declare o que deveria acontecer (resultado esperado)
	 */
	
	// Testes de construtor ---------------------------------------------------------------------------------
	
		// criar o objeto quando os dados forem válidos
		@Test
		public void constructorShouldCreateObjWhenValidData() {
			// Arrange
			Double totalAmount = 100000.0;
			Double income = 2000.0;
			Integer months = 80;
					
			// Act
			Financing fin = new FinancingFactory().creatFinancing(totalAmount, income, months);
					
			// Assert
			Assertions.assertEquals(totalAmount, fin.getTotalAmount());	
			Assertions.assertEquals(income, fin.getIncome());	
			Assertions.assertEquals(months, fin.getMonths());		
			Assertions.assertEquals(1000.0, fin.quota());	
		}
		
		// Lançar exceção quando os dados forem inválidos
		@Test
		public void constructorShouldThrowExceptionWhenWhenInvalidData() {
			// Assertions
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Arrange
				Double totalAmount = 100000.0;
				Double income = 2000.0;
				Integer months = 20;
							
				// Act
				Financing fin = new FinancingFactory().creatFinancing(totalAmount, income, months);			
			});
		}
}
