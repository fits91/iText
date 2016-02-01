package ua.com.fits;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import ua.com.fits.service.IOService;
import ua.com.fits.service.ImageService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by fits on 28.01.16.
 */
public class Itext {
    public static void main(String[] args) {
        String base64 = null;
        try {
            base64 = new IOService().readFileToStr("testFile.txt");
            byte[] bytes = Base64.decode(base64);

            BufferedImage inImage = ImageService.getImageFromBytes(bytes);
            Dimension inDemension = new Dimension(inImage.getWidth(), inImage.getHeight());
            System.out.println(inImage.getWidth());

            int type = inImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : inImage.getType();
            Dimension outImageDimension = ImageService.getScaledDimension(inDemension, new Dimension(300, 150));

            BufferedImage outImage = ImageService.resizeImage(inImage, outImageDimension, type);

            File outputfile = new File("image.jpg");
            ImageIO.write(outImage, "jpg", outputfile);

            System.out.println(outImage.getWidth() + " " + outImage.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }



//        try {
//            new ItextService().createPDF("imgpng.png");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
