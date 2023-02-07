package EjercicioEntregable2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try {
            InetAddress direccion = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            for (int i = 1; i < 1000; i++) {
                String mensaje = "Mensaje: "+i;
                byte[] buffer = mensaje.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
                socket.send(packet);
            }
            String mensaje = "FIN";
            byte[] buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
            socket.send(packet);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
