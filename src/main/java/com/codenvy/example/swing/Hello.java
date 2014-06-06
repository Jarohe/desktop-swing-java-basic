package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Hello {

    public static void main(String[] args) {

        // Create a new JFrame

        JFrame frame = new JFrame();
        frame.setTitle("Hello World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use image from URL

        Image imageIcon = null;
        try {
            URL url = new URL("http://docs.codenvy.com/wp-content/uploads/codenvy-header-logo1.png");
            imageIcon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();

        }

        // Create a new menubar

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.setToolTipText("This Is A Menubar");

        // Cretae a menu, with sub-menu item, and use ActionListener and ActionEvent to use hotkeys to close an app

        JMenu menu = new JMenu("Click Me");
        menuBar.add(menu);
        JMenuItem mntmClose = new JMenuItem("Exit");
        mntmClose.setMnemonic(KeyEvent.VK_Q);
        mntmClose.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        mntmClose.setToolTipText("Exit this app");
        mntmClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(mntmClose);

        // Add a new JLabel

        JLabel label = new JLabel(new ImageIcon(imageIcon));
        frame.getContentPane().add(label);

    // make the frame half the height and width
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);

        // Center the jframe on screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}