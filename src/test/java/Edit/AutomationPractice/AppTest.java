package Edit.AutomationPractice;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    int resultado = 0;
	
	// Método o Procedimiento
    @Test
    public void shouldAnswerWithTrue()
    {
        resultado = sumarDosNumeros(25, 50);
        System.out.println("El resultado de la suma es: " + resultado);
    }
 
    // Funcion
    public int sumarDosNumeros(int numA, int numB) 
    {
    	return numA + numB;
    }
}
