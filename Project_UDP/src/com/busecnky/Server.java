package com.busecnky;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server {

    private static byte[] buffer = new byte[256];
    private static final int PORT = 5000;
    private static ArrayList<Integer> ports = new ArrayList<>();
    private static final InetAddress address;
    private static DatagramSocket socket;
   
    static {
        try {
            socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
  
    public static void main(String[] args) {

        System.out.println("Server started on this port " + PORT);

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length); 
            try {
                socket.receive(packet); 
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String message = new String(packet.getData(), 0, packet.getLength()); 
            System.out.println("Server received: " + message);


            if (message.contains("START")) {
                ports.add(packet.getPort());
            }
          
            else {
                int userPort = packet.getPort();  
                byte[] byteMessage = message.getBytes(); 

               
                for (int forward_port : ports) {
                    if (forward_port != userPort) {
                        DatagramPacket forward = new DatagramPacket(byteMessage, byteMessage.length, address, forward_port);
                        try {
                            socket.send(forward);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }


        }
    }
}