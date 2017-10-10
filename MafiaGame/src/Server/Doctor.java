package Server;

public class Doctor extends Player {

    void heal(String playerName) {
        for(Player player : Server.players) {
            if(player.name.equals(playerName)) {
                player.healed = true;
            }
        }
    }

}
