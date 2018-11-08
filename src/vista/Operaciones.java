package vista;

import java.util.Scanner;
import java.math.*;

public class Operaciones {
	
	
	public void verificarCoprimosYMCD(){ //Metodo inicial para verificar si 2 numeros son coprimos y su MCD
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Verificar Numeros Coprimos y determinar su MCD");
		System.out.print("Ingrese el Primer Numero: ");
		int numero1 = sc.nextInt();
		System.out.println(numero1);
		System.out.print("Ingrese el Segundo Numero: ");
		int numero2 = sc.nextInt();
		System.out.println(numero2);
		if (verificarPrimo(numero1) == true && verificarPrimo(numero2) == true){
			System.out.println("Los numeros ingresados son coprimos, ya que ambos son primos");
			System.out.println("El MCD de los numeros Coprimos en 1");
		}else if(obtenerMCD(numero1, numero2) == 1){
			System.out.println("Los numeros " + numero1 +" y " + numero2 + " son coprimos");
			System.out.println("El MCD de los numeros Coprimos en 1");
		}else{
			System.out.println("Los numeros " + numero1 +" y " + numero2 + " no son coprimos");
			System.out.println("El MCD de los numeros "+ numero1 + " y " + numero2 + " = " +obtenerMCD(numero1, numero2));
		}
	}

	
	public boolean verificarPrimo(int numero){ //Metodo para verificar si 2 numeros son primos
		int primo = 0;
		int divisor = 2;
		int raiz = (int)(Math.sqrt(numero));
		while((primo == 0) && (divisor <= raiz)){
			if (numero % divisor == 0){
				primo += 1;
			}
			divisor += 1;
		}		
		if (primo == 0){
			return true;
		}else{
			return false;
		}
	}
	
	
	public int obtenerMCD(int numero1, int numero2){ //Metodo para obtener el MCD de 2 numeros
		int resto;
		if (numero1 < numero2){
			int numero = numero1;
			numero1 = numero2;
			numero2 = numero;
		}
		while(numero2 != 0){
			resto = numero1 % numero2;
			numero1 = numero2;
			numero2 = resto;
		}
		return numero1;
	}
	
	public void generadorCongruencial(){
		Scanner sc = new Scanner (System.in);
		double semilla = 0;
		int repeticiones = -1;
		long a = 1103515245;
		double m = Math.pow(2, 32);
		
		System.out.println("Generador Congruencial");
		while(semilla <= 0){
			System.out.println("Ingrese una semilla (El valor debe ser mayor a 0): ");
			semilla = sc.nextDouble();
			if (semilla <= 0){
				System.out.println("El numero ingresado es menor o igual a 0");
			}
		}
		while(repeticiones < 0){
			System.out.println("Ingrese la cantidad de numeros aleatorios que desea (El valor debe ser mayor a 0): ");
			repeticiones = sc.nextInt();
			if (repeticiones <= 0){
				System.out.println("El numero ingresado es menor o igual a 0");
			}	
		}
		for(int i=0; i<repeticiones; i++){
			semilla = datosGenerador(a, semilla, m);
			double valor = (semilla / m *100);
			System.out.println("El numero aleatorio " + (i+1) + " es: " + valor);
		}	
	}
	
	public double datosGenerador(long a, double semilla, double m){ //Metodo para actualizar la semilla en Generador Congruencial
			double valor = ((a*semilla + 12345) % m);
			System.out.println(valor);
			semilla = valor;
			return semilla;
	
	}
	
	public void generadorVonNeumann(){
		Scanner sc = new Scanner (System.in);
		long semilla = 0;
		int repeticiones = -1;
		int n = 0;
		
		System.out.println("Generador Von Neumann");
		while(semilla <= 0){
			System.out.println("Ingrese una semilla (El valor debe ser mayor a 0 y la cantidad de digitos debe ser par): ");
			semilla = sc.nextLong();
			n = Long.toString(semilla).length();
			if (semilla <= 0){
				System.out.println("El numero ingresado es menor o igual a 0");
			}
			if (n % 2 != 0){
				System.out.println("La cantidad de digitos es impar");
				semilla = 0;
			}
		}
		while(repeticiones < 0){
			System.out.println("Ingrese la cantidad de numeros aleatorios que desea (El valor debe ser mayor a 0): ");
			repeticiones = sc.nextInt();
			if (repeticiones <= 0){
				System.out.println("El numero ingresado es menor o igual a 0");
			}	
		}
		
		double valor;
		for(int i=0; i<repeticiones; i++){
			valor = (double) semilla * semilla;
			semilla = (long)(valor/Math.pow(10, (int)(n/2))) % (long)Math.pow(10, n);
			System.out.println("El numero aleatorio " + (i+1) + " es: " + (long)(semilla/Math.pow(10, n)*100));
		}
	}
}