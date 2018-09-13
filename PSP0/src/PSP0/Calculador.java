package PSP0;

import javax.swing.JOptionPane;

public class Calculador {

	public static void main(String[] args) {
		
		Lista valoresLista = new Lista();;
		
		double numero;
		int opcion=0;
		do{
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "1.Agregar valores a X"+
			"\n2. Agregar valores a Y \n3. Calcular Regresion y correlacion \n4. Salir", "Menu de opciones", 3));
				
				switch(opcion){
				case 1:
					try{
						numero = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el numero",
								"Insertando valores al listado X",3));
						valoresLista.agregarLista1(numero);
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
					}
					break;
				case 2:
					try{
						numero = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el numero",
								"Insertando valores al listado Y",3));
						valoresLista.agregarLista2(numero);
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
					}
					break;
				case 3:
					valoresLista.media();
					valoresLista.elevado();
					valoresLista.multiplicar();
					valoresLista.correlacion();
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
