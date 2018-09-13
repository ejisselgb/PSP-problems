import java.util.Scanner;

public class Main {
	

	private static Scanner consola;

	public static void main(String[] args) {
		
		consola = new Scanner(System.in);
		/* llamado a la clase encargada de capturar los datos para evaluar la integral */
		CapturaDatos capturaDatos = new CapturaDatos(); 
		int numeroSegmentos;
		int dof;
		double x;
		try{
			
			System.out.println("Calculo de una integral definida con la regla de Simpson \n" + "Ingrese los valores por consola");
			System.out.println("Definir valor para tamaño del arreglo:");
			numeroSegmentos = (int)consola.nextDouble() + 1;
			System.out.println("Definir valor para numero del grado (dof): ... ESTE DATO ES UN ENTERO");
			dof = (int)consola.nextDouble();
			System.out.println("Definir valor de x para la funcion (Si es decimal separarlo con coma)");
			x = consola.nextDouble();
					
			/*Se invocan metodos de la clase captura datos encargados de almacenar datos en 
			 * variables y de invocar el metodo para el calculo de la interfaz*/
			capturaDatos.agregarDatosVariable(numeroSegmentos, dof, x);
			capturaDatos.guadarDatosArreglo();
			capturaDatos.calculoIntegral();	
			
		}catch(Exception e){
			System.out.println("Se intento insertar un dato incorrecto");
		}
	}
}
