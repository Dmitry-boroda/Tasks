import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class DownloadRunnable implements Runnable{

    private final ProgressCallback callback;
    private final String name;

    public DownloadRunnable(ProgressCallback callback, String name) {
        this.callback = callback;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("started at"+ new Date());
        int count = 0;
        String url = "https://files-example-com.github.io/uploads/files_example_MP4_640_3MG.mp4";
        try(BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(name +".mp4")){

            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = inputStream.read(buffer,0,1024)) != -1){
                fileOutputStream.write(buffer,0,bytesRead);
                count ++;
                callback.updatePercentage(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("finish at"+ new Date());
            System.out.println("count "+ count);
        }
    }
}
