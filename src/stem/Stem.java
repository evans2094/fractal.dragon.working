package stem;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;

public class Stem{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame window = new JFrame("Dragons");
        window.setSize(1000, 800);
//      window.setContentPane(new DragonView(250,400,550,400,Color.BLACK,10));
        window.setContentPane(new DragonView());
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
	}

}
