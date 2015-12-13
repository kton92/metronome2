import java.util.TimerTask;

public class Task extends TimerTask {

    private Diody diody;
    private int metrum;

    int i = 0;

    public Task(Diody p_diody, int p_metrum) {
        diody = p_diody;
        metrum = p_metrum;
    }

//    long time = 0;
//    long time2 = 0;

    @Override
    public void run() {

//        time2 = time;
//        time = System.currentTimeMillis();

        int index = i % metrum;
//        System.out.println("index=" + index + ", time=" + (time - time2));

        if (metrum == 1) {
            index = i % 2;
            diody.setState(0, index == 0, true);
        } else {
            diody.setState(0, false, false);
            diody.setState(1, false, false);
            diody.setState(2, false, false);
            diody.setState(3, false, false);
            diody.setState(index, true, false);
        }
        i++;
    }
}
