/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erika
 */
public class ContadorLineas {
    
    public ContadorLineas(){}
    
    public void contar(String path){
        
        /* se recibe el path de la carpeta o del archivo desde la interfaz grafica */
        File fichero = new File(path); 
        File[] ficheros;
        
        try{
            if (fichero.isDirectory()){
                /* se listan los archivos si son traidos desde la interfaz */
                ficheros = fichero.listFiles();
                
                if(ficheros.length <= 0){
                    System.out.println("La carpeta esta vacia");
                }
                
                for (int x=0;x<ficheros.length;x++){
                    BufferedReader leerfich = new BufferedReader(new FileReader(ficheros[x].getAbsolutePath()));
                    int contadorL = 0;
                    int contadorM = 0;
                    String linea;
                    try {
                        while((linea = leerfich.readLine()) != null){
                  
                            String newlinea = linea.replaceAll(" ", "");
                     
                            if(!newlinea.equals("") && !newlinea.contains("/*")){
                                contadorL++;
                            }
                            if(newlinea.contains("){")&&(newlinea.contains("public")||newlinea.contains("private")||newlinea.contains("protected"))){
                                contadorM++;
                            }
                        }
                        
                        System.out.println("Conteo de lineas de la clase " + ficheros[x].getName());    
                        System.out.println("El número de lineas totales de la clase " + ficheros[x].getName()+ " son: " + contadorL);
                        System.out.println("El número de metodos de la clase :" + ficheros[x].getName() + " son: " + contadorM);
                        System.out.println("\n");
                        
                    } catch (IOException e) {}
                }
            }else{
                /*Se lee lineas de codigo desde un unico archivo*/
                try{
                    BufferedReader leerfich = new BufferedReader(new FileReader(fichero));
                    int contadorL = 0;
                    int contadorM = 0;
                    String linea;
                    try {
                        while((linea = leerfich.readLine()) != null){
                                
                            String newlinea = linea.replaceAll(" ", "");
                             
                            if(!newlinea.equals("") && !newlinea.contains("/*")){
                                contadorL++;
                            }

                            if(newlinea.contains("){")&&(newlinea.contains("public")||newlinea.contains("private")||newlinea.contains("protected"))){
                                contadorM++;
                            }   
                        }
                        System.out.println("El número de lineas totales de la clase: " + contadorL);
                        System.out.println("El número de metodos de la clase: " + contadorM);
                    } catch (IOException e) {}
                    
                }catch (FileNotFoundException e) {} 
            }
        }catch (FileNotFoundException e) {} 
    }   
}
