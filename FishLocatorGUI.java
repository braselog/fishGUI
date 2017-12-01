package com.example;

/**
 * Created by logan on 12/1/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class FishLocatorGUI extends JFrame{
    static File imgFile;
    static File outFile;
    static JLabel imgFileName;
    static JLabel outFileName;
    static JLabel errorLabel;
    static JButton imgButton;
    static JButton outFileButton;
    static JButton runButton;

    public FishLocatorGUI(){
        setTitle("Fish Locator");
        setSize(400,200);
        setLocation(10,200);
    }
    public static void main(String args[]){
        final JFrame f = new FishLocatorGUI();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }});

        f.setLayout(new GridLayout(3,2,5,20));
        imgButton = new JButton("Images File");
        imgButton.setSize(100,20);
        f.add(imgButton);
        imgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fc.showOpenDialog(f);
                if (returnVal == JFileChooser.APPROVE_OPTION){
                    imgFile = fc.getSelectedFile();
                    imgFileName.setText(imgFile.toString());
                }

            }
        });

        imgFileName = new JLabel("Select a file...");
        f.add(imgFileName);

        outFileButton = new JButton("Output File");
        outFileButton.setSize(100,20);
        f.add(outFileButton);
        outFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fc.showOpenDialog(f);
                if (returnVal == JFileChooser.APPROVE_OPTION){
                    outFile = fc.getSelectedFile();
                    outFileName.setText(outFile.toString());
                }
            }
        });
        outFileName = new JLabel("Select a file...");
        f.add(outFileName);

        runButton = new JButton("Run!");
        runButton.setSize(100,20);
        f.add(runButton,CENTER_ALIGNMENT);
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (imgFile == null || outFile == null){
                    errorLabel.setText("SELECT FILES FIRST!");
                }
                else {
                    errorLabel.setText("Running...");

//                Run the Program stuff!!!!
                }
            }
        });
        errorLabel = new JLabel("");
        f.add(errorLabel);
        f.show();
    }
}
