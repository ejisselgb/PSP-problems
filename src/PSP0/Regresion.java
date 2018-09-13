package PSP0;

public class Regresion {
	
	/*se definen las variables segun el documento*/
	double b0;
	double b1;
	double xy;
	double x2;
	double y2;
	
	/*se definen las variables que se inicializan con los datos traidos de la clase lista*/
	double sumatoria;
	double tamano;
	double mediaX, mediaY;
	double ex, ey;
	
	public Regresion(double sumatoriamulti, double tamano1, double valorMedia, double valorMedia2, double sumatoriaEX, double sumatoriaEY){
		
		b0 = 0;
		b1 = 0;
		xy = 0;
		x2 = 0;
		y2 = 0;
		sumatoria = sumatoriamulti;
		tamano = tamano1;
		mediaX = valorMedia;
		mediaY = valorMedia2;
		ex = sumatoriaEX;
		ey = sumatoriaEY;
		
		
	}
	
	/*Se realiza el calculo de la correlacion y la regresion lineal*/
	public void calculoCR(){
			
		double b1 = (sumatoria - (tamano*mediaX*mediaY)) / ((ex) - (tamano*Math.pow((mediaX), 2)));
		double valuexy1 = (tamano*ex) - Math.pow((mediaX), 2);
		double valuexy2 = (tamano*ey) - Math.pow((mediaY), 2);
		double xy = ((tamano*sumatoria)-(mediaX*mediaY))/(Math.sqrt(valuexy1) * Math.sqrt(valuexy2));			
		double b0 = (mediaY - (b1 * mediaX));
		double yk = b0 + b1 * (386);
		
		System.out.println("\n");
		System.out.println("B1 " + b1);
		System.out.println("Rxy " + xy);
		System.out.println("B0 " + b0);
		System.out.println("Yk " + yk);
		
	}
}
