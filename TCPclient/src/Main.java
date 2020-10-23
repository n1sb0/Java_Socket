import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main {
	
	
	public static void main(String[]args) {
		
		try {
			//creo e dichiaro il soggetto gui per chiamare costruttore quale in seguito avvia il run
			GUI gui=new GUI();
			
			//avvio GUI
			SwingUtilities.invokeAndWait(GUI.GuiRunnable);		

			//creo e dichiaro il soggetto client
			ClientTcp client= new ClientTcp();			
			
			//Collego al pulsante un Evento OnClick
			GUI.InviaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Evento comunica con server e invia i dati
					client.comunica();						
				}
			});
			
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}	
		
	}
}
