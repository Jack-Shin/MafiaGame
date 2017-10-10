package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerSocket servSock;
    private Socket socket;
    public static List<Player> players;
    public static boolean isGameInProgress = false;
    public static EnumTime time = EnumTime.DAY;

    void run() {
        try {
            players = new ArrayList<>();
            servSock = new ServerSocket(10042);
            while(true) {
                socket = servSock.accept();
                Player player = new Player();
                player.setDisDos(new DataInputStream(socket.getInputStream()),
                        new DataOutputStream(socket.getOutputStream()));
                players.add(player);

                if (players.size() == 6) {
                    GameStarter gamestarter = new GameStarter();
                    gamestarter.startGame();
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }


    }


    public static void synchronize() { // it is used for client to synchronize to server
        //have to be implemented

        String json = ""; // have to be changed

        for(Player player : Server.players) {
            player.send(json);
        }
    }
}
