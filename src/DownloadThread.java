public class DownloadThread extends Thread{


    private final Runnable runnable;

    public DownloadThread(String name, ProgressCallback callback) {
        this.runnable = new DownloadRunnable(callback, name);
    }

    @Override
    public void run() {
        super.run();
        runnable.run();
    }
}
