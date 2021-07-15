public class Team extends Thread {
    public String teamNames;
    public String[] runnerNames;

    public Team(String teamNames, String[] runnerNames) {
        this.teamNames = teamNames;
        this.runnerNames = runnerNames;
    }

    public void run() {
        try {
            Runner firstRunner = new Runner(teamNames, runnerNames[0]);
            Runner secondRunner = new Runner(teamNames, runnerNames[1], firstRunner);
            Runner thirdRunner = new Runner(teamNames, runnerNames[2], secondRunner);
            Runner fourthRunner = new Runner(teamNames, runnerNames[3], thirdRunner);

            firstRunner.start();
            secondRunner.start();
            thirdRunner.start();
            fourthRunner.start();

            fourthRunner.join();

            System.out.println("Участник " + runnerNames[3] + " из команды " + teamNames + " финишировал");

            if (Relay.winnerTeam == null)
                Relay.winnerTeam = teamNames;
        }
        catch (Exception e) {
        }
    }
}
