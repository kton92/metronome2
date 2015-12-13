import java.util.Timer;

public class Silnik implements Runnable {

    private static final int SEC_IN_MINUTE = 60;
    private static final int MILLISECONDS = 1000;

    private int tempo;
    private int metrum;
    private Diody diody;
    private int przerwa;

    private Timer timer;

    Silnik(int p_tempo, int p_metrum, Diody p_diody) {
        tempo = p_tempo;
        metrum = p_metrum;
        diody = p_diody;
        przerwa = (SEC_IN_MINUTE * MILLISECONDS / tempo);
        timer = new Timer(true);
    }

    @Override
    public void run() {

        Task task = new Task(diody, metrum);
        timer.schedule(task, 0, przerwa);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void stop() {
        timer.cancel();
        diody.setState(0, false, false);
        diody.setState(1, false, false);
        diody.setState(2, false, false);
        diody.setState(3, false, false);
    }
}
