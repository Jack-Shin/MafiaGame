package Server;


public class Police extends Player {

     void checkIfMafia(String playerName) {
         for (Player player : Server.players) {
             if (player.name.equals(playerName) && player.job == EnumJobs.MAFIA) {
                send("The player who you wanted to check is not mafia");
                break;
             }
         }
     }
}
