

import java.util.Scanner;
import java.util.regex.*;

public class UsoPattern {

	public static void main(String[] args) {
		
		Pattern pat=null;
		Matcher mat=null;
		Scanner miScanner = new Scanner(System.in);
		
		// pat=Pattern.compile(patron);
		// Teléfono (formato 000-000000)
		//pat=Pattern.compile("[0-9]{3}.[0-9]{6}");
		//DNI
		//pat=Pattern.compile("[0-9]{8}-[a-zA-Z]");
		
		System.out.print("Introduce un Dni correcto: ");
		String dniIntroducido = miScanner.nextLine();
		mat = pat.matcher(dniIntroducido);

		while(!mat.matches()){

			System.out.println("El Dni introducido es incorrecto, por favor "

                   + "introduzca un Dni válido.");

			System.out.print("Introduce un Dni correcto:");

			dniIntroducido = miScanner.nextLine();

			mat = pat.matcher(dniIntroducido);

		}

		System.out.println("Bien, el Dni " + dniIntroducido + " es un Dni válido");


	}

}
