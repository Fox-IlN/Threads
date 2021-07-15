public class Relay {
    public String[] teamNames;
    public String[][] runnerNames;
    public static String winnerTeam = null;

    Relay(String[] teamNames, String[][] runnerNames) {
        this.teamNames = teamNames;
        this.runnerNames = runnerNames;
    }

    public String run() {
        try {
            Team firstTeam = new Team(teamNames[0], runnerNames[0]);
            firstTeam.start();

            Team secondTeam = new Team(teamNames[1], runnerNames[1]);
            secondTeam.start();

            firstTeam.join();
            secondTeam.join();

            return winnerTeam;
        }catch (Exception e){
            return "Что-то пошло не так";
        }
    }
}
