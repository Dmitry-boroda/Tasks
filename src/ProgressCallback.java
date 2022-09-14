import java.io.PrintStream;


public interface ProgressCallback {

    void updatePercentage(int count);

    class Base implements ProgressCallback{

        private int total = 0;

        @Override
        public synchronized void updatePercentage(int count) {
            total+=count;
        }

        public void showTotal(PrintStream stream){
            stream.println(total);
        }
    }
}
