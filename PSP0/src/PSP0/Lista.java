package PSP0;

public class Lista {
	
	/*Se declaran las variables*/
	public Nodo inicio1, inicio2, fin;
	double valorMedia, valorMedia2;
	double tamano1;
	double tamano2;
	double sumatoria, sumatoria2, sumatoriaEX, sumatoriaEY, sumatoriamulti;
	double elevado, elevado2;
	double valormultiplicacion;
	Regresion regresion;
	
	/*Se inicializan las variables*/
	public Lista(){
		inicio1 = null;
		inicio2 = null;
		fin = null;
		regresion = null;
		tamano1 = 0;
		tamano2 = 0;
		sumatoria = 0;
		valorMedia = 0;
		valormultiplicacion = 0;
	}
	
	/*Se agregan elementos a la lista X*/
	public void agregarLista1(double elemento){
		inicio1 = new Nodo(elemento, inicio1);
		tamano1 ++;
		
		if(fin==null){
			fin=inicio1; 
		}
		
		System.out.println("\n X");
		System.out.print("["+inicio1.dato+"]");
	}
	
	/*Se agregan elementos a la lista Y*/
	public void agregarLista2(double elemento){
		inicio2 = new Nodo(elemento, inicio2);
		tamano2 ++;
		
		if(fin==null){
			fin=inicio2; 
		}
		
		System.out.println("\n Y");
		System.out.print("["+inicio2.dato+"]");
	}
	
	/*Se calcula la media*/
	public void media(){
		
		Nodo recorrer = inicio1;
		Nodo recorrer2 = inicio2;
		
		while(recorrer != null && recorrer2 != null){
				
			sumatoria = sumatoria + recorrer.dato;
			recorrer = recorrer.siguiente;
				
			sumatoria2 = sumatoria2 + recorrer2.dato;
			recorrer2 = recorrer2.siguiente;
		}
			
		valorMedia = sumatoria / tamano1;
		valorMedia2 = sumatoria2 / tamano2;
	}
	
	/*Se elevan al cuadrado los valores de los listados X y Y y se realiza la sumatoria independiente*/
	public void elevado(){
		
		Nodo recorrer = inicio1;
		Nodo recorrer2 = inicio2;
		
		while(recorrer != null && recorrer2 != null){
			
			elevado = 0;
			elevado = Math.pow((recorrer.dato), 2);
			sumatoriaEX = sumatoriaEX + elevado;
			
			elevado2 = 0;
			elevado2 = Math.pow((recorrer2.dato), 2);
			sumatoriaEY = sumatoriaEY + elevado2;
			
			recorrer = recorrer.siguiente;
			recorrer2 = recorrer2.siguiente;
		}
		
		System.out.println("\n");
		System.out.println("X^2 " + sumatoriaEX );
		System.out.println("Y^2 " + sumatoriaEY);
	}
	
	/*Se multiplican los valores de los listados y se realizan las sumatorias*/
	public void multiplicar(){
		
		Nodo recorrer = inicio1;
		Nodo recorrer2 = inicio2;
		if(tamano1 == tamano2){
			while(recorrer != null && recorrer2 != null){
				
				valormultiplicacion = recorrer.dato*recorrer2.dato;
				recorrer = recorrer.siguiente;
				recorrer2 = recorrer2.siguiente;
				
				sumatoriamulti = sumatoriamulti + valormultiplicacion;
			}
			
			System.out.println("\n");
			System.out.println("x*y = " + sumatoriamulti);	
		}		
	}
	
	/*Se realiza el llamado de la funcion del calculo de correlacion y regresion*/
	public void correlacion(){
		
		if(tamano1 == tamano2 && tamano1 >= 2 && tamano2 >= 2){
			regresion = new Regresion(sumatoriamulti, tamano1, valorMedia, valorMedia2, sumatoriaEX, sumatoriaEY);
			regresion.calculoCR();
		}else{
			System.out.println("Los listados deben ser iguales o deben contener al menos dos elementos \npara poder realizar el calculo de regresion y correlacion");
		}
	}
}
