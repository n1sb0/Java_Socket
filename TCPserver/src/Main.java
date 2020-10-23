import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[]args) {				
		try {
			//creo e dichiaro il soggetto gui per chiamare costruttore quale in seguito avvia il run
			GUI gui=new GUI();
			
			//avvio GUI
			SwingUtilities.invokeAndWait(GUI.GuiRunnable);			

			//creo e dichiaro il soggetto server
			ServerTCP server=new ServerTCP();
			
			//creo un ciclo while dove metto il server sempre in asscolta
			//(Un loop infinito)
			while(true) {
				//ascolta, riceve la connessione
				server.ascolta();
				
				//comunica, risponde al clint
				server.comunica();		
			}
			
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}		
	}	
}
