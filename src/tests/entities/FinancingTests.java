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
	
	// Testes de setTotalAmount ---------------------------------------------------------------------------------
		
		// Atualizar o valor Total quando os dados forem válidos
		@Test
		public void newTotalAmountShouldSetTotalAmountWhenValidData() {
			// Arrange
			Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
			
			// Act
			fin.setTotalAmount(90000.0);
			
			// Assert
			Assertions.assertEquals(90000.0, fin.getTotalAmount());	
			Assertions.assertEquals(900.0, fin.quota());		
		}
		
		// Lançar exceção quando os dados forem válidos (valor Total)
		@Test
		public void newTotalAmountShouldExceptionWhenWhenInvalidDat() {
			// Assertions
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Arrange
				Double totalAmount = 100001.0;
				Double income = 2000.0;
				Integer months = 20;
									
				// Act
				Financing fin = new FinancingFactory().creatFinancing(totalAmount, income, months);			
			});	
		}
	
	// Testes de setIncome ---------------------------------------------------------------------------------------
	
		// Atualizar o valor Income quando os dados forem válidos
		@Test
		public void setIncomeShouldSetDataWhenValidData() {
			// Arrange
			Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
						
			// Act
			fin.setIncome(2500.0);
						
			// Assert
			Assertions.assertEquals(1000.0, fin.quota());			
		}
		
		// Lançar exceção quando os dados forem válidos (valor Income)
		@Test
		public void setIncomeShouldExceptionWhenInvalidData() {
			// Assertions
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Arrange
				Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
				
				// Act
				fin.setIncome(1800.0);
			});
		}
		
	// Testes de setMonth ---------------------------------------------------------------------------------------
		
		// Atualizar o valor Income quando os dados forem válidos
		@Test
		public void setMonthShouldSetDataWhenValidData() {
			// Arrange
			Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
						
			// Act
			fin.setMonths(100);
						
			// Assert
			Assertions.assertEquals(800.0, fin.quota());			
		}
		
		// Lançar exceção quando os dados forem válidos (valor Income)
		@Test
		public void setMonthShouldExceptionWhenInvalidData() {
			// Assertions
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// Arrange
				Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
							
				// Act
				fin.setMonths(79);
			});
		}
	
	// Testes de entry ---------------------------------------------------------------------------------------
		
		// Calcular corretamente o valor da entrada
		@Test
		public void ObjShouldCalculateInputWhenValidData() {
			// Arrange
			Double expectedValue = 20000.00;
								
			// Act
			Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
								
			// Assert
			Assertions.assertEquals(expectedValue, fin.entry());			
		}
		
	// Testes de quota ---------------------------------------------------------------------------------------
		
		// Calcular corretamente o valor da prestação
		@Test
		public void ObjShouldCalculateInstallmentWhenValidData() {
			// Arrange
			Double expectedValue = 1000.00;
										
			// Act
			Financing fin = new FinancingFactory().creatFinancing(100000.0, 2000.0, 80);
										
			// Assert
			Assertions.assertEquals(expectedValue, fin.quota());			
		}
}
