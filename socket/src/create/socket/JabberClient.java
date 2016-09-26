package create.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* this is modified on github
**/
public class JabberClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InetAddress ip = InetAddress.getByName(null);
		Socket socket = new Socket(ip, JabberServer.PORT);
		try {
			System.out.println("Client JabberClient2 socket:" + socket);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
				);
				
				PrintWriter out = new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(
										socket.getOutputStream())), true);
				for (int i = 0; i < 10; i++) {
					out.println("Hello " + i);
					String str = in.readLine();
					System.out.println(str);
				}
				out.print("END");
		} finally {
			socket.close();
		}
	}

}
