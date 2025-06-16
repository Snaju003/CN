import java.io.*;
import java.net.*;
public class Server
{
    public static void main(String[] args) {
        try{
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        Socket socket  = server.accept();
        System.out.println("Client connected: " + socket.getInetAddress());
        
        BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String message= in.readLine();
        System.out.println("Received message: " + message);

        in.close();
        socket.close();
        server.close();
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}