package UDP.Bi;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message to be sent");
            String message = sc.nextLine();
            byte[] buffer = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sentPacket = new DatagramPacket(buffer, 0, buffer.length, serverAddress, 5000);
            socket.send(sentPacket);

            byte[] replyBuffer = new byte[1024];
            DatagramPacket replyPacket = new DatagramPacket(replyBuffer, replyBuffer.length);
            socket.receive(replyPacket);
            String serverReply = new String(replyPacket.getData());
            System.out.println("Server: " + serverReply);

            socket.close();
            sc.close();
        } catch (IOException ioEX) {
            System.out.println("Error:" + ioEX.getMessage());
        }
    }
}
