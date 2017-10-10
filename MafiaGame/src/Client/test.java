package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class test {


    public static void main(String[] args) {
        System.out.println("client");
        try {
            Socket socket = new Socket("localhost", 10042);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Fucking name");
            while(true) {
                //nothing to do
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
