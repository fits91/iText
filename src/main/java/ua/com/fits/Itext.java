package ua.com.fits;

import com.itextpdf.text.DocumentException;
import ua.com.fits.service.ItextService;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by fits on 28.01.16.
 */
public class Itext {
    public static void main(String[] args) {
        try {
            new ItextService().createPDF("imgpng.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
