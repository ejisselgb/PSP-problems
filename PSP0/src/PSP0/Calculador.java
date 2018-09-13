package PSP0;

import javax.swing.JOptionPane;

public class Calculador {

	public static void main(String[] args) {
		
		Lista valoresLista = new Lista();
		
		double numero;
		int opcion=0;
		do{
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "1.Agregar un numero a la lista"+
			"\n2. Calcular Media \n3. Calcular desviacion estandar \n4. Salir", "Menu de opciones", 3));
				
				switch(opcion){
				case 1:
					try{
						numero = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el elemento",
								"Insertando al inicio",3));
						valoresLista.agregarLista(numero);
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
					}
					break;
				case 2:
					valoresLista.media();
					break;
				case 3:
					valoresLista.mediaDesviacion();
					break;
				case 4:
					break;
				default:
				}
			}catch(Exception e){
				
			}
		}while(opcion!=4);

	}

}
