package ua.com.fits;

import com.itextpdf.text.DocumentException;
import ua.com.fits.service.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by fits on 28.01.16.
 */
public class Itext {
    public static void main(String[] args) {
        try {
            new Service().createPDF("img.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
