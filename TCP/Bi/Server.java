package TCP.Bi;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ServerSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            Socket socket = ServerSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String message = in.readLine();
            System.out.println("Received message: " + message);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter response to send: ");
            String response = sc.nextLine();
            out.println(response);
            // System.out.println("Sent response: " + response);

            ServerSocket.close();
            socket.close();
            sc.close();
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
