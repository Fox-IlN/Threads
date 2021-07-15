public class Runner extends Thread {
    public String runnerNames;
    public String teamNames;
    public Runner nextRunner;
    public int count = 0;
    public final int maxCount = 50;

    public Runner(String teamNames, String runnerNames){
        this.teamNames = teamNames;
        this.runnerNames = runnerNames;
    }

    public Runner(String teamNames, String runnerNames, Runner nextRunner){
        this.teamNames = teamNames;
        this.runnerNames = runnerNames;
        this.nextRunner = nextRunner;
    }

    public void run(){
        try {
            if (nextRunner!=null)
            nextRunner.join();

            while (count < maxCount){
                ++count;
                System.out.println("Участник " + runnerNames + " из команды " + teamNames +" пробежал " + count + "м");
                sleep((long) Math.random() * 100);
            }

            System.out.println("Участник " + runnerNames + " из команды " + teamNames + " передал эстафету");
        }catch (Exception e){
        }
    }
}
