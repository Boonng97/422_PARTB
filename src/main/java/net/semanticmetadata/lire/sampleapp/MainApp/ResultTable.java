package net.semanticmetadata.lire.sampleapp.MainApp;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ResultTable {

    String[] Result;
    JPanel resultPanel;
    public void SetTable(String[] Result)
    {
        this.Result=Result;
        resultPanel=new JPanel(new FlowLayout());
        try {

            for (int i = 0; i < Result.length; i++) {

                BufferedImage img = null;
                if (!Result[i].startsWith("http:")) {
                    // check isf it is a jpg file ...
                    if (Result[i].toLowerCase().endsWith(".jpg")) {
                        img = ImageIO.read(new FileInputStream(Result[i]));
                    }
                } else {
                    img = ImageIO.read(new URL(Result[i]));
                }
                JLabel imgLabel = new JLabel(new ImageIcon(img));
                resultPanel.add(imgLabel);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel ResultPanel()
    {
        return resultPanel;
    }

}
