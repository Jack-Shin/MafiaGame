package Server;

public class GameStarter {
    void startGame() {

        int[] r = new int[6];
        for(int i =0 ; i<6 ; i++){
            r[i] = (int)(Math.random() * 6);
            for(int j = 0; j < i; j++){
                if(r[i] == r[j]){
                    i = i-1;
                    break;
                }
            }
        }

        Server.players.get(r[0]).job = EnumJobs.MAFIA;
        Server.players.get(r[1]).job = EnumJobs.POLICE;
        Server.players.get(r[2]).job = EnumJobs.DOCTOR;


        Server.players.get(r[3]).job = EnumJobs.CITIZEN;
        Server.players.get(r[4]).job = EnumJobs.CITIZEN;
        Server.players.get(r[5]).job = EnumJobs.CITIZEN;

        for(int i = 0; i < 6; i++) {
            Player player = Server.players.get(i);

            if(player.job == EnumJobs.MAFIA) {
                Mafia mafia = (Mafia)player;
                Server.players.set(i, mafia);
            } else if(player.job == EnumJobs.DOCTOR) {
                Doctor doctor = (Doctor)player;
                Server.players.set(i, doctor);
            } else if(player.job == EnumJobs.POLICE) {
                Police police = (Police) player;
                Server.players.set(i, police);
            } else if(player.job == EnumJobs.CITIZEN) {
                Citizen citizen = (Citizen) player;
                Server.players.set(i, citizen);
            }
            Server.players.get(i).startReceiving();
        }

        Server.isGameInProgress = true;

        new Thread(() -> {
            while(Server.isGameInProgress != false) {
                try {
                    Server.time = EnumTime.DAY;
                    Thread.sleep(90000);

                    Server.synchronize(); //for client-side timer

                    Server.time = EnumTime.VOTING;
                    Thread.sleep(15000);

                    Server.synchronize(); //for client-side timer

                    Server.time = EnumTime.NIGHT;
                    Thread.sleep(10000);

                    Server.synchronize(); //for client-side timer
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}











