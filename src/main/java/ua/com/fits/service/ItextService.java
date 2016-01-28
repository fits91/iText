package ua.com.fits.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by fits on 28.01.16.
 */
public class ItextService {

    public void createPDF(String imagePath) throws IOException, DocumentException {


        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("itext.pdf"));

        document.open();
        document.add(new Paragraph("Hello World!"));

        if(!imagePath.isEmpty()) {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            System.out.println(originalImage.getHeight() + " " + originalImage.getWidth());
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            BufferedImage resizeImage = ImageService.resizeImage(originalImage, type);

            Image image = Image.getInstance(ImageService.getBytesFromBufferedImage(resizeImage));

            document.add(image);
        }

        document.close();
    }

    public byte[] getBytesFrom(String imgPath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(imgPath));
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int readNum = 0;
        while ((readNum = fis.read(buf)) != -1) {
            bos.write(buf, 0, readNum); //no doubt here is 0
            //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
//            System.out.println("read " + readNum + " bytes,");
        }

        byte[] bytes = bos.toByteArray();

        return bytes;
    }


}
