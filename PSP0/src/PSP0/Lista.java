package PSP0;

public class Lista {
	
	public Nodo inicio, fin;
	double valorMedia;
	double tamano;
	double sumatoria;

	public Lista(){
		inicio = null;
		fin = null;
		tamano = 0;
		sumatoria = 0;
		valorMedia = 0;
	}
	
	
	public void agregarLista(double elemento){
		inicio = new Nodo(elemento, inicio);
		tamano ++;
		
		if(fin==null){
			fin=inicio; 
		}
		
		System.out.print("["+inicio.dato+"]--->");
	}
	
	public void media(){
		
		Nodo recorrer = inicio;
		
		if(recorrer != null ){
			while(recorrer != null){
				
				sumatoria = sumatoria + recorrer.dato;
				recorrer = recorrer.siguiente;
			}
			
			valorMedia = sumatoria / tamano;
			System.out.println("\n La media calculada es: " + valorMedia);
			
		}else{
			System.out.println("\n Debe agregar valores a la lista enlazada");
		}

	}
	
	public void mediaDesviacion(){
		
		Nodo recorrer = inicio;
		double valorDesviacion = 0;
		double elevado = 0;
		double sumaDesviacion = 0;

	
		if(sumatoria != 0 && tamano != 0){
			
			while(recorrer != null){
				
				elevado = Math.pow((recorrer.dato - valorMedia), 2);
				sumaDesviacion = sumaDesviacion + elevado;	
				recorrer = recorrer.siguiente;
				
			}
			
			valorDesviacion = Math.sqrt(sumaDesviacion / (tamano-1));
			System.out.println("\n El valor de la desviacion estandar es: " + valorDesviacion);
			
		}else{
			System.out.println("\n Por favor, calcule primero la media");
		}
	}
}
