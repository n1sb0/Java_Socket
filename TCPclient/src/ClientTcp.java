import java.io.*;
import java.net.*;


public class ClientTcp {
	String nome_server="localhost";
	int porta_server=4444;
	Socket socket;
	String stringa_utente;
	String stringa_ricevuta_server;
	DataOutputStream out_verso_server;
	BufferedReader in_dal_server;	
	
	//connessione con server
	public Socket connetti() {
		try {
			//creo e dichiaro un soggetto socket, con i parametri:
			//(nome_server = ip-server , porta_server = porta-analogica su quale si connetta per comunicare)
			socket= new Socket(nome_server,porta_server);
			
			//dichiaro un Buffer 'DataReader' per poter mandare un messaggio al server
			out_verso_server= new DataOutputStream(socket.getOutputStream());
			in_dal_server=new BufferedReader(new InputStreamReader(socket.getInputStream()));			
		} catch (Exception e) {	e.printStackTrace();} 		
		return socket;
	}
	
	//stabilisce la connessione e comunica con server
	public void comunica() {	
		
		//leggo il campo textField (il messaggio inserito dal client)
		stringa_utente =GUI.textField.getText();
		
		//controllo se il messaggio non e` vuoto
		if(!stringa_utente.equals("")) {		
		    try {    
		    	//stabilisce la connessione con server
				connetti();
				
				//dopo aver stabilito la connessione invia la Stringa (il messaggio) da client
			    out_verso_server.writeBytes(stringa_utente+"\n");
			    
			    //server risponde con una Stringa modificata, quale memoriziamo dentro var = (stringa_ricevuta_server)
			    stringa_ricevuta_server=in_dal_server.readLine();
			    
			    //aggiungiamo (append) il risultato alla nostra textArea sul lato client (la Stringa modificata)
			    GUI.textArea.append("Stringa ricevuta dal server:\t"+ stringa_ricevuta_server +"\n");
			    GUI.textArea.append("----- \n");
		    } catch (IOException e) {		e.printStackTrace();		}		
		}else {
			//se il messaggio mandato da client e` vuoto appare il messaggio di errore
			GUI.textArea.append("Errore: la Stringa non puo` essere letta \n");
		}
		
			
	}
}


