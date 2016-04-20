/**
 * 
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author INTI-0332
 *
 */
//author : Raphael FOURQUET date : 18/04/2016
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
		
		double t = 0;	//RFRF : temperature to convert.
		double res;	//RFRF : convert temperature.
		char loopTrigger = ' ';	//RFRF : Main loop trigger.
		char mode;	//RFRF : °C to °F OR °F to °C.
		boolean tempOk;	//RFRF : Vérifie la saisie correcte de l'utilisateur sur la température.
		
		System.out.println("CONVERTISSEUR DEGRE CELSIUS/FAHRENHEIT");
		System.out.println("--------------------------------------\n");
		
		Scanner sc = new Scanner(System.in); 
		
		//RFRF : Main loop
		do {
			
			//RFRF : Conversion mode
			do {
				mode = ' ';
				System.out.println("Choisissez le mode de conversion : ");
				System.out.println("1 - Conversion Celsius - Fahrenheit.");
				System.out.println("2 - Conversion Fahrenheit - Celsius.");
				mode = sc.nextLine().charAt(0);
			} while(mode != '1' && mode != '2');
			
			//RFRF : Temperature V1 : sans gestion d'exception.
			//System.out.println("Température à convertir :");
			//t = sc.nextDouble();
			
			//RFRF : InputMismatchException a catch.
			//RFRF : Temperature V3 : gestion exception
			do {
				tempOk = true;
				System.out.println("Température à convertir :");
				try {
					t = sc.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("\tAttention : Veuillez entrer un nombre.");
					tempOk = false;
					sc.nextLine();	//RFRF : Flush ? Entre 2 nextDouble aussi ? Non pk ici ?
				}
			} while(!tempOk);
			
			//RFRF : Temperature V2 ?
			/*do {
				System.out.println("Température à convertir :");
				//System.out.println("min/max double : "+Double.MIN_VALUE+" "+Double.MAX_VALUE); //RFRF : min/max double : 4.9E-324 1.7976931348623157E308
				if(sc.hasNextDouble()) {
					t = sc.nextDouble();	//RFRF : vérifier qu'on récupère un chiffre : do while t est un double ?
					tempOk = true;
				}
			//} while(t<Double.MIN_VALUE && t>Double.MAX_VALUE); //ATESTER même problème, exception si pas chiffre
			//} while(Double.isNaN(t));	//Même probleme, l'erreur se déclenche au niveau de l'appel à nextDouble.
			} while(!tempOk);*/
			
			//RFRF : Flush scanner P37 : Si nextLine() après un nextAutre ...
			sc.nextLine();
			
			//RFRF : Compute and display result
			//RFRF : switch according to mode.
			/*if(mode==1) {
				res = arrondi(toFarenheit(t),2);
				System.out.println(t+" °C correspond a : "+res+" °F.");
			} else if(mode==2) {
				res = arrondi(toCelsius(t),2);
				System.out.println(t+" °F correspond a : "+res+" °C.");
			} else
				System.err.println("Error : impossible case.");*/
			switch(mode) {
			case '1' :
				res = arrondir(toFahrenheit(t),2);
				System.out.println(t+" °C correspond à : "+res+" °F.");
				break;
			case '2' :
				res = arrondir(toCelsius(t),2);
				System.out.println(t+" °F correspond à : "+res+" °C.");
				break;
			default :
				System.err.println("Error : impossible case.");
			}
			
			//RFRF : Other conversion ?
			do {
				loopTrigger = ' ';
				//RFRF : On demande si la personne veut faire un autre essai    
				System.out.println("Souhaitez-vous effectuer une nouvelle conversion ? (O/N)");    
				loopTrigger = sc.nextLine().charAt(0);
			} while(loopTrigger != 'O' && loopTrigger != 'N');
		} while(loopTrigger == 'O');
		
		//RFRF : Good bye !
		System.out.println("Au revoir !");
		
		sc.close();

	}
	
	//OpenClassRoom function.
	public static double arrondir(double a, int b) {
		return (double) ( (int) (a * Math.pow(10, b) + .5)) / Math.pow(10, b); 
	}
	
	/**
	 * 
	 * @param f temperature (°Fahrenheit)
	 * @return temperature (°Celsius)
	 */
	public static double toCelsius(double f) {
		return (f-32.0)*5.0/9.0;	
	}
	
	/**
	 * 
	 * @param c temperature (°Celsius)
	 * @return temperature (°Fahrenheit)
	 */
	public static double toFahrenheit(double c) {
		return 9./5.*c+32.;
	}


}
