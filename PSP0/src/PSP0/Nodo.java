package PSP0;

public class Nodo {

	/* Aqui se declaran las variables que va a tomar el nodo */
	public double dato;
	public Nodo siguiente; 

	public Nodo(double d, Nodo n){
		dato = d;
		siguiente = n;
	}

	public double pasarDato(){
		return dato;
	}
}