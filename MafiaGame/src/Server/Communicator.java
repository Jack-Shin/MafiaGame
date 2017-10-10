package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Communicator {
    DataOutputStream dos;
    DataInputStream dis;

    void startThread() {
        Thread reciever = new Thread(() -> {


            while(true) {
                try {
                    String json = dis.readUTF();
                    //json 처리
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        });
        reciever.start();
    }

    void send(String json) {
        try {
            dos.writeUTF(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
