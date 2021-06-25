package net.semanticmetadata.lire.sampleapp.MainApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Test j=new Test(frame.getContentPane());
        frame.setVisible(true);
        frame.pack();

    }
}
