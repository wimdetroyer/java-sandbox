package be.wimdetroyer.javasandbox.jcip.testing;

public class TimedBarrierAction implements Runnable {


    private boolean startedTimer = false;
    private long startTime, endTime;
    @Override
    public void run() {
        long time = System.currentTimeMillis();
        if(startedTimer) {
            endTime = time;
        } else {
            startTime = time;
            startedTimer = true;
        }
    }

    //TODO: why synch?


    public synchronized void clear() {
        startedTimer = false;
    }
    public synchronized long getDuration() {
        return endTime - startTime;
    }
}
