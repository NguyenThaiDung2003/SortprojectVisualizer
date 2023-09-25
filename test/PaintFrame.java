package test;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author tauit_dnmd
*/
public class PaintFrame extends JFrame
{
	public static final String strImagePath="/image/background.png";
	ImageIcon background;
	JPanel jpanel;
	public PaintFrame() {
	
		background=null;
		this.setSize(300,200);
		jpanel=new JPanel(){
			@Override
			protected  void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(background!=null)
				{
					g.drawImage(background.getImage(),
					0,0,getWidth(),getHeight(),null);
				}
			}
		};
		setContentPane(jpanel);	
	}
	public void setBackground(ImageIcon img) {
		this.background=img;
	}
	public static void main(String[] str) {
		PaintFrame frame = new PaintFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBackground(new ImageIcon(PaintFrame.class.getResource("/image/background.png")));
		frame.setVisible(true);
	}
}