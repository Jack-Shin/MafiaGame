package Server;

import java.io.IOException;

public class Mafia extends Player {
    void kill(String playerName) {
        try {
            for(Player player : Server.players) {
                if(player.name.equals(playerName) && player.healed == false) {
                    player.alive = false;
                } else {
                    player.healed = false;
                }
            }
            dos.writeUTF("blabla kill command should be changed"); //send message to players
        } catch(IOException e) {
            e.printStackTrace();
        }
        Server.synchronize();
    }
}