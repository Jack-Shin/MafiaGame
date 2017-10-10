package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Player extends Communicator{
   // DataOutputStream dos;
   // DataInputStream dis;

    //-------- Player Data --------
    String name;
    EnumJobs job;
    boolean alive = true; // true : alive , false : dead
    boolean healed = false; // true : healed , false : not healed



    void setDisDos(DataInputStream dis, DataOutputStream dos){
        super.dis = dis;
        super.dos = dos;
        try {
            this.name = dis.readUTF();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
