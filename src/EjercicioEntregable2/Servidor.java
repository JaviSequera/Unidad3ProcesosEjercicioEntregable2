package EjercicioEntregable2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(42500);
            byte[] buffer = new byte[64];
            String mensaje = "";
            String[] mensajeSplit;

            while (!mensaje.equals("FIN")){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                mensaje = new String(packet.getData()).trim();
                mensajeSplit = mensaje.split(" ");
                escritura(mensajeSplit[1]);
            }

        }catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String escritura(String texto) {
        String lectura = "";
        File archivo;
        FileWriter fr = null;
        try {
            archivo = new File("ficheroEscritura.txt");
            fr = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fr);
            bw.write(texto);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lectura;
    }
}


