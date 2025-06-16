package ECHO;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on PORT 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client connected " + socket.getInetAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Received from Client(" + socket.getInetAddress() + "):" + message);

                out.println(message);

                socket.close();
            } catch (Exception e) {
                System.out.println("Connection Closed.");
            }
        }
    }
}
