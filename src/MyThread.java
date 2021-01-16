import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    private DbxClientV2 client;
    private BufferedImage outpImage;
    public MyThread (DbxClientV2 clientV2, BufferedImage image) {
        client = clientV2;
        outpImage = image;
    }

    @Override
    public void run() {

        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
       // System.out.println(dateFormat.format(dateNow));
        String fileName = dateFormat.format(dateNow) + ".png";
        System.out.println(fileName);


        try{
            ByteArrayOutputStream intermedImage = new ByteArrayOutputStream();
            ImageIO.write(outpImage, "png", intermedImage);
            InputStream in = new ByteArrayInputStream(intermedImage.toByteArray());
            client.files().uploadBuilder("/"+fileName).uploadAndFinish(in);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
