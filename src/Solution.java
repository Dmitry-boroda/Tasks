import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
       List<Thread> list = new ArrayList<>();
       int total = 0;

       ProgressCallback.Base callback = new ProgressCallback.Base();
       list.add(new DownloadThread("one",callback));
       list.add(new DownloadThread("two",callback));

       for(Thread thread : list){
           thread.start();
       }
        for(Thread thread : list){
            thread.join();
        }

       callback.showTotal(System.out);
    }

}

