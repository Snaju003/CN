package TCP.Bi;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost",5000);
            System.out.println("Connected to server at port 5000");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message to send: ");
            String message = sc.nextLine();
            out.println(message);
            String response = in.readLine();
            System.out.println("Received response from server: " + response);

            sc.close();
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
