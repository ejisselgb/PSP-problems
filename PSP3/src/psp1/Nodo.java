/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp1;

/**
 *
 * @author erika
 */
public class Nodo {
	
	// Aqui se declaran las variables que va a tomar el nodo
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