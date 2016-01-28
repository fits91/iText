package ua.com.fits.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

/**
 * Created by fits on 28.01.16.
 */
public class Service {

    public void createPDF(String imagePath) throws IOException, DocumentException {


        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("itext.pdf"));

        document.open();
        document.add(new Paragraph("Hello World!"));

        if(!imagePath.isEmpty()) {
            Image image = Image.getInstance(extractBytes(imagePath));
            document.add(image);
        }

        document.close();
    }

    public byte[] extractBytes(String filePath) {

        FileInputStream fileInputStream = null;

        File file = new File(filePath);

        if(!file.exists()) {
            throw new NullPointerException("File no exists");
        }

        byte[] bFile = new byte[filePath.length()];

        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bFile;
    }

}
