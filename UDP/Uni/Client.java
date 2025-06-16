package UDP.Uni;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message to be sent");
            String message = sc.nextLine();
            byte[] buffer = message.getBytes();

            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
            socket.send(packet);

            socket.close();
            sc.close();

        } catch (IOException ioEX) {
            System.out.println("Error:" + ioEX);
        }
    }
}
