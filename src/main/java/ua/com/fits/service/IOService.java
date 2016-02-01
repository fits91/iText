package ua.com.fits.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by developer on 01.02.2016.
 */
public class IOService {

    public String readFileToStr(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = null;

        String currentLine;

        br = new BufferedReader(new FileReader(filePath));

        while((currentLine = br.readLine()) != null) {
            sb.append(currentLine);
        }

       return sb.toString();
    }

}
