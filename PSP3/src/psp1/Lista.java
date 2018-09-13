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
public class Lista {
	
	public Nodo inicio, fin, inicioM, finM;
	double valorMedia, varianza, desviacion, ln_avg;
	double tamano;
	double sumatoria, sumatoriaLogaritmo;

	public Lista(){
		inicio = null;
		fin = null;
                inicioM = null;
                finM = null;
		tamano = 0;
		sumatoria = 0;
		valorMedia = 0;
                varianza = 0;
                sumatoriaLogaritmo = 0;
                desviacion = 0;
                ln_avg = 0;
                
            System.out.println("CLASSNAME ---> LOC ---> METHODS ---> LOC/METHODS ---> LN(Xi)");
	}
        
	public void agregarLista(String name, double loc, double item){
            
            inicio = new Nodo(loc, inicio); //Agregar LOC
            inicioM = new Nodo(item, inicioM); // Agregar Items
            tamano ++;
		
            if(fin==null && finM == null){
                fin=inicio; 
                finM = inicioM;
            } 

            double division = inicio.dato / inicioM.dato; 
            double logaritmoNatural = Math.log(division);
            sumatoriaLogaritmo = sumatoriaLogaritmo + logaritmoNatural;    
            
            System.out.print(name + " --->");
            System.out.print("["+inicio.dato+"]--->");
            System.out.print("["+inicioM.dato+"]--->");
            System.out.print("["+division+"]--->");
            System.out.print("["+logaritmoNatural+"]--->");
	}
     
	public void media(){
           
            valorMedia = sumatoriaLogaritmo / tamano;
            System.out.println("\n");
            System.out.println("La media calculada es: " + valorMedia);
       
	}
        
        public void logaritmo(){
            
            Nodo recorrer = inicio;
            Nodo recorrer2 = inicioM;
            
            while(recorrer != null && recorrer2 != null){
                
                double division = recorrer.dato / recorrer2.dato; 
                double logaritmoNatural = Math.log(division);

                double calculo_ln_avg = Math.pow((logaritmoNatural - valorMedia),2);
                ln_avg = ln_avg + calculo_ln_avg;
               
                recorrer = recorrer.siguiente;
                recorrer2 = recorrer2.siguiente;
            }
        }
	
        public void varianzaDesviacion(){
            
            varianza = ln_avg / (tamano - 1);
             
            desviacion = Math.sqrt(varianza);
            
            System.out.println("La varianza calculada es: " + varianza);
            System.out.println("La desviacion calculada es: " + desviacion);
        }
        
        public void rangoLog(){
            
            double vs = valorMedia - (2*desviacion);
            double s = valorMedia - desviacion;
            double m = valorMedia;
            double l = valorMedia + desviacion;
            double vl = valorMedia + (2*desviacion);
            
            System.out.println("VS: " + vs);
            System.out.println("S: " + s);
            System.out.println("M: " + m);
            System.out.println("L: " + l);
            System.out.println("VL: " + vl);
      
            // Antilogaritmo       
           double avs = Math.exp(vs);
           double as = Math.exp(s);
           double am = Math.exp(m);
           double al = Math.exp(l);
           double avl = Math.exp(vl);
           
           System.out.println("eVS: " + avs);
           System.out.println("eS: " + as);
           System.out.println("eM: " + am);
           System.out.println("eL: " + al);
           System.out.println("eVL: " + avl);
        }
}