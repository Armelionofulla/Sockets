import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        String host = "localhost"; 

        Socket clientSocket = new Socket(host, port);
        System.out.println("Connected to server!");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.print("Enter message: ");
            String message = in.readLine();
            out.println(message);

            String response = serverIn.readLine();
            System.out.println("Server response: " + response);
        }
    }
}
