import java.io.*;
import java.net.*;

public class ServerTCP {
	ServerSocket server =null;
	Socket client=null;
	String ricevuta=null;
	String modificata=null;
	BufferedReader in_dal_client;
	DataOutputStream out_verso_client;	
	
	//costruttore 
	ServerTCP(){
		
		//stabilisce la porta di comunicazione
		try {			
			server=new ServerSocket(4444);			
			GUI.textField.append("Server in Esecuzione...\n");
		}catch (Exception e) {e.printStackTrace();}		
		
		GUI.textField.append("Server e` pronto. \n");
		GUI.textField.append("----- \n");
	}
	
	//accetta il socket del client
	public Socket ascolta() {			
		try {		
			//accoglie il socket  arrivato e lo salva dentro il soggetto client
			client=server.accept();		
			
			//dichiaro un Buffer 'DataReader' per poter mandare un messaggio al client
			in_dal_client=new BufferedReader(new InputStreamReader(client.getInputStream()));
			out_verso_client=new DataOutputStream(client.getOutputStream());
			
			//in teoria gia` qui possiamo chiudere la connessione, ma la lasciamo apperto perche` voglio che 
			//anche gli altri si connettono dopo
		    //server.close();
		} catch (Exception e) {e.printStackTrace();}		
		return client;		
	}
	
	//risponde/comunica con client
	public void comunica() {	
		
		try {
			//sul server al textField aggiungiamo un messaggio che significa che il client si e` conness
			String ip_client = client.getInetAddress().toString();
			GUI.textField.append("Si e` connesso il nuovo client. (" + ip_client.substring(1, ip_client.length()) + ") \n");
			GUI.textField.append("Elaboro la sua richiesta ... \n");
			
			
			//legge la Stringa dal client
			ricevuta=in_dal_client.readLine();
			
			//La modifica toUpperCase = trasforma in maiuscolo la Stringa
			modificata=ricevuta.toUpperCase();
			
			//invia la Stringa modificata
			out_verso_client.writeBytes(modificata+"\n");
			
			
			GUI.textField.append("Finito :) \n");
			GUI.textField.append("----- \n");
			//chiude la connessione con particolare client
			
			client.close();
		} catch (Exception e) {e.printStackTrace();}		
	}
}



/*server=new ServerSocket();
InetAddress inetAddress=InetAddress.getLocalHost();
SocketAddress endPoint=new InetSocketAddress(inetAddress, 4444);  
server.bind(endPoint);+server.getInetAddress()*/