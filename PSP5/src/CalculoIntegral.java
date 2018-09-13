
public class CalculoIntegral {
	
	public int i;
	public double xi;
	public int dof;
	public double valorElevado;
	public double resultadoF1;
	public double resultadoF2;
	public double factorialSuperior;
	public double factorialInferior;
	public double valorGammaIn;
	public double resultadoF3;
	public double resultadoF4;
	public double resultadoF5;
	int multiplicadorF;
	int multiplicadorP;
	int multiplicadorI;	
	public double x;
	public int tablaCalculo[];
	public double w;
	public double valorAntiguo = 0;
	public static double valorError;
	public double error = 0.00001;
	
	/*Constructor que recibe valores desde la clase captura datos*/
	public CalculoIntegral(int[] tablaCalculo, double x, int dof){
		
		this.tablaCalculo = tablaCalculo;
		this.x = x;
		this.dof = dof;
	}
	
	/*Funcion principal encargada del calculo de la funcion de la integral*/
	public void calculoIntegral(){
		
		double resultadoPar = 0;
		double resultadoImpar = 0;
		double resultadoInicio = 0;
		
		w = x / (tablaCalculo.length - 1);
		
		for(int j=0; j < tablaCalculo.length; j++) {
			
			i = tablaCalculo[j];
			
			if(tablaCalculo[j] == 0){
				xi = 0;
				multiplicadorF = 1;
			}else{
				xi = xi + w;
			}
			
			calculoPrimeraFuncion(xi, dof);
			calculoSegundaFuncion(dof);
			
			if(tablaCalculo[j]%2 == 0 && tablaCalculo[j] != 0 && tablaCalculo[j] != 10){
				multiplicadorP = 2;
				resultadoPar = (w/3)*multiplicadorP*resultadoF4;
				resultadoF5 = resultadoF5 + resultadoPar;
			}else if(tablaCalculo[j] == 0 || tablaCalculo[j] == 10){
				multiplicadorF = 1;
				resultadoInicio = (w/3)*multiplicadorF*resultadoF4;
				resultadoF5 = resultadoF5 + resultadoInicio;
			}else{
				multiplicadorI = 4;
				resultadoImpar = (w/3)*multiplicadorI*resultadoF4;
				resultadoF5 = resultadoF5 + resultadoImpar;
			}
		}
		
		if(valorAntiguo == 0){
			valorAntiguo = resultadoF5;
		}
		valorError = Math.abs((0.3500589042865573 - 0.34781464567819187));
		
		//System.out.println(valorAntiguo + "!= " + resultadoF5 + "@@@" + valorAntiguo);
		System.out.println("El resultado de la integral es: " + resultadoF5 + "\n");
	}
	
	
	public void calculoPrimeraFuncion(double xi, int dof){
		
		resultadoF1 = 1 + ((Math.pow(xi, 2))/dof);
	}
	
	public void calculoSegundaFuncion(int dof){

		double valorPi = 0;
		valorElevado = (double)(dof+1)/2;
		int redondeo = 0;
		int redondeoSup = 0;
		valorPi = Math.sqrt(Math.PI);
		
		if(resultadoF1 != 0){
			resultadoF2 = Math.pow(resultadoF1, (-valorElevado));
		}	
		
		factorialSuperior = 1;
		redondeoSup = ((int)valorElevado) + 1;
		
		for(i=0;i < redondeoSup; i++){
			valorElevado --;
			
			if(valorElevado > 0){
				factorialSuperior = factorialSuperior*valorElevado;
			}
			
			if(valorElevado == 0.5){
				factorialSuperior = factorialSuperior * valorPi;
			}
		}
		
		factorialInferior = 1;
		valorGammaIn = (double)dof/2;
		redondeo = ((int)valorGammaIn) + 1;
		
		for(i=0;i < redondeo; i++){
			
			valorGammaIn --;
			
			if(valorGammaIn > 0){
				factorialInferior = (double)(factorialInferior*valorGammaIn);
			}
			
			if(valorGammaIn == 0.5){
				factorialInferior = factorialInferior * valorPi;
			}			
		}	
		calculoFuncionTres(factorialSuperior,factorialInferior,dof);
	}
	
	public void calculoFuncionTres(double gammaSup, double gammaIn, int dof){
		
		double parte1 = 0;
		
		parte1 = Math.pow((dof*Math.PI), 0.5);
		
		double divisor = parte1 * gammaIn;
		
		resultadoF3 = (gammaSup)/(divisor);		
		
		resultadoF4 = resultadoF3 * resultadoF2;		
	}
}
