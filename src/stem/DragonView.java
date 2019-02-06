package stem;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class DragonView extends JPanel implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color color;
	int iterations,x1,x2,y1,y2;
	protected JButton b_inc,b_dec, b_show;
	boolean type;
    /**
	 * 
	 */
	DragonView (){
		
		this.color = Color.BLACK;
		this.iterations = 1;
		this.x1 = 244;
		this.y1 = 500;
		this.x2 = 756;
		this.y2 = 500;
		this.type = false;
		
		b_inc = new JButton("Increase");
		b_inc.setVerticalTextPosition(AbstractButton.CENTER);
		b_inc.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
		b_inc.setMnemonic(KeyEvent.VK_I);
		b_inc.setActionCommand("plus");

		b_show = new JButton(this.type +": Iter:"+this.iterations);
		b_show.setVerticalTextPosition(AbstractButton.BOTTOM);
		b_show.setHorizontalTextPosition(AbstractButton.CENTER); //aka LEFT, for left-to-right locales
		b_show.setMnemonic(KeyEvent.VK_O);
		b_show.setActionCommand("switch");

		b_dec = new JButton("Decrease");
	    //Use the default text position of CENTER, TRAILING (RIGHT).
		b_dec.setMnemonic(KeyEvent.VK_D);
		b_dec.setActionCommand("minus");

	    //Listen for actions on buttons 1 and 3.
		b_inc.addActionListener(this);
		b_show.addActionListener(this);
	    b_dec.addActionListener(this);

	    b_inc.setToolTipText("Increase iteration count.");
	    b_show.setToolTipText("Current iteration count.");	    
	    b_dec.setToolTipText("Decrease iteration count.");

	    //Add Components to this container, using the default FlowLayout.
	    add(b_dec);
	    add(b_show);
	    add(b_inc);
	};


/*	DragonView (Color col, int iter){
		this.color=col;
		this.iterations=iter;
		this.x1 = 250;
		this.y1 = 400;
		this.x2 = 550;
		this.y2 = 400;
		this.type = true;
	}
	
	DragonView (int x_1,int y_1, int x_2, int y_2, Color col, int iter){
		this.color=col;
		this.iterations=iter;
		this.x1 = x_1;
		this.y1 = y_1;
		this.x2 = x_2;
		this.y2 = y_2;
		this.type = true;
	}*/
	
	

	public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.setColor(this.color);
        g.clearRect(0, 0, 1000, 800);
        drawDragon(this.x1, this.y1, this.x2, this.y2, this.iterations, g, this.type);
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if ("plus".equals(e.getActionCommand())) {
            this.iterations+=1;
            b_show.setText(this.type +": Iter:"+this.iterations);
            if (this.iterations > 0) b_dec.setEnabled(true);
        };
        
        if ("minus".equals(e.getActionCommand())) {
        	this.iterations-=1;
        	if (this.iterations == 0) b_dec.setEnabled(false);
            b_show.setText(this.type +": Iter:"+this.iterations);        	
        };
        
        if ("switch".equals(e.getActionCommand())) {
        	this.type=!this.type;
        };
    };	
		
    private void drawDragon(int x1, int y1, int x2, int y2, int n, Graphics g,boolean type)
    {
        int xx, yy;
        if(n < 0) n=0;
        if(n > 0)
        {
            xx = (x1 + x2) / 2 + (y2 - y1) / 2;
            yy = (y1 + y2) / 2 - (x2 - x1) / 2 ;
            if (type) drawDragon(x2, y2, xx, yy, n - 1, g, type); else drawDragon(xx, yy, x2, y2, n - 1, g, type); 
            drawDragon(x1, y1, xx, yy, n - 1, g, type);
        }
        if(n == 0)
            g.drawLine(x1, y1, x2, y2);
    }

}