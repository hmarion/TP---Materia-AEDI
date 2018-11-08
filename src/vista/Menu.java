 package vista;

import java.util.Scanner;

public class Menu {

	private int opcion1 = 1;
	
	public void mostrarMenu(){
		
		while(opcion1 != 0){
				
			try{
						
				Scanner sc = new Scanner (System.in);
				Operaciones ops = new Operaciones();
		
				System.out.println("Bienvenido al Menu de Seleccion");
				System.out.println("1 - Verificar Numeros Coprimos");
				System.out.println("2 - Generar numeros aleatorios (Metodo Von Newman)");
				System.out.println("3 - Generar numeros aleatorios (Generador Congruencial)");
				System.out.println("0 - Salir.");
				System.out.print  ("Ingrese la opcion seleccionada: ");
		
				opcion1 = sc.nextInt();
				switch (opcion1) 
				{
				case 1: 
					ops.verificarCoprimosYMCD();
					break;
		
				case 2: 
					ops.generadorVonNeumann();
					break;
					
				case 3:
					ops.generadorCongruencial();
					break;
				
				case 0:
					System.out.println("Gracias por utilizar nuestro programa!");
					break;
					
				default:
					System.out.println("La opcion ingresada es incorrecta");
				}
			}catch(Exception e){
				System.out.println("Ingreso un caracter no valido");
			}
		}
	}
}
