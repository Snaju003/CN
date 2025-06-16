package ECHO;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",5000);
            System.out.println("Connected to Server");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out= new PrintWriter(socket.getOutputStream(),true);
            Scanner sc= new Scanner(System.in);

            System.out.println("Enter your message:");
            String message = sc.nextLine();

            out.println(message);
            String receivedMessage=in.readLine();
            System.out.println("Server Says:"+receivedMessage);

            socket.close();
            sc.close();
            
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}
