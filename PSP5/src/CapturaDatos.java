import java.util.Scanner;

public class CapturaDatos {
	
	Scanner consola = new Scanner(System.in);
	
	public int numeroArray;
	
	public int dof;
	
	public double error;
	
	public double x;

	public int numeroSegmentos[];
	
	public CalculoIntegral calculoIntegral;
	
	public CapturaDatos(){

		numeroArray = 0;
		dof = 0;
		error = 0.00001;
		x = 0;	
	}
	
	/*Metodo para agregar datos a las variables definidas desde el main*/
	public void agregarDatosVariable(int numeroArray, int dof, double x){
		
		this.numeroArray = numeroArray;
		this.dof = dof;
		this.x = x;	
		numeroSegmentos = new int [numeroArray];
	}
	
	/*Construir arreglo*/
	public void guadarDatosArreglo(){
		
		for (int i=0; i < numeroSegmentos.length; i++) {
			numeroSegmentos[i] = i;
		}
	}
	
	/*Invocar metodo de la clase claculo integral encargado de llevar a cabo el calculo de la integral*/
	
	public void calculoIntegral(){
		
		calculoIntegral = new CalculoIntegral(numeroSegmentos, x, dof);
		calculoIntegral.calculoIntegral();
	}
}
