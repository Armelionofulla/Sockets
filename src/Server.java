import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port );

        while (true) {

            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected! (Total connections: " + Thread.activeCount() + ")");


            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message = in.readLine();
                System.out.println("Client message: " + message);


                String convertedMessage = message.toUpperCase();

                out.println(convertedMessage);

                System.out.println("Converted message sent to client.");
            } catch (IOException e) {
                System.err.println("Error communicating with client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
