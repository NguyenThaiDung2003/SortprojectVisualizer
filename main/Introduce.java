package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Introduce extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Introduce frame = new Introduce();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Introduce() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
		setExtendedState(JFrame.MAXIMIZED_BOTH);//
		setLocationRelativeTo(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed();
			}
		});
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBounds(31, 33, 116, 54);
		contentPane.add(btnBack);
		
		JLabel lblWelcome = new JLabel("");
		lblWelcome.setIcon(new ImageIcon(Introduce.class.getResource("/image/welcome.png")));
		lblWelcome.setBounds(313, 77, 1019, 144);
		contentPane.add(lblWelcome);
		
		JLabel Text1 = new JLabel("Welcome to 10th team's application\r\n");
		Text1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Text1.setBounds(31, 263, 388, 54);
		contentPane.add(Text1);
		
		JLabel Text2 = new JLabel("We'll provide you 4 Sorting Algorithms Animations");
		Text2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Text2.setBounds(32, 296, 568, 85);
		Text2.setVisible(false);
		contentPane.add(Text2);
		
		JLabel lblMergeSort = new JLabel("");
		lblMergeSort.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblMergeSort.setIcon(new ImageIcon(Introduce.class.getResource("/image/MergeSort.jpg")));
		lblMergeSort.setBounds(0, 400, 376, 307);
		lblMergeSort.setVisible(false);
		contentPane.add(lblMergeSort);
		
		JLabel lblSelectionSort = new JLabel("");
		lblSelectionSort.setBackground(Color.WHITE);
		lblSelectionSort.setIcon(new ImageIcon(Introduce.class.getResource("/image/SelectionSort.png")));
		lblSelectionSort.setBounds(380, 400, 338, 297);
		lblSelectionSort.setVisible(false);
		contentPane.add(lblSelectionSort);
		
		JLabel lblBubbleSort = new JLabel("");
		lblBubbleSort.setIcon(new ImageIcon(Introduce.class.getResource("/image/BubbleSort.png")));
		lblBubbleSort.setBounds(728, 400, 312, 297);
		lblBubbleSort.setVisible(false);
		contentPane.add(lblBubbleSort);
		
		JLabel lblBucketSort = new JLabel("");
		lblBucketSort.setIcon(new ImageIcon(Introduce.class.getResource("/image/BucketSort.png")));
		lblBucketSort.setBounds(1055, 400, 331, 302);
		lblBucketSort.setVisible(false);
		contentPane.add(lblBucketSort);
		
		JLabel Mergetitle = new JLabel("Mergesort\r\n");
		Mergetitle.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Mergetitle.setBounds(131, 360, 116, 54);
		Mergetitle.setVisible(false);
		contentPane.add(Mergetitle);
		
		JLabel Seclectiontitle = new JLabel("Selectionsort\r\n");
		Seclectiontitle.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Seclectiontitle.setBounds(472, 360, 159, 54);
		Seclectiontitle.setVisible(false);
		contentPane.add(Seclectiontitle);
		
		JLabel Bubbletitle = new JLabel("Bubblesort\r\n");
		Bubbletitle.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Bubbletitle.setBounds(808, 360, 159, 54);
		Bubbletitle.setVisible(false);
		contentPane.add(Bubbletitle);
		
		JLabel Buckettitle = new JLabel("Bucketsort\r\n");
		Buckettitle.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Buckettitle.setBounds(1173, 360, 159, 54);
		Buckettitle.setVisible(false);
		contentPane.add(Buckettitle);
		
		JLabel ClickLabel = new JLabel("Click to join with us!");
		ClickLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		ClickLabel.setBounds(998, 242, 244, 54);
		ClickLabel.setVisible(false);
		contentPane.add(ClickLabel);
		
		JButton btnJoin = new JButton("JOIN\r\n");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				(new MainFrame()).setVisible(true);
			}
		});
		btnJoin.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		btnJoin.setForeground(Color.RED);
		btnJoin.setBackground(Color.WHITE);
		btnJoin.setBounds(1023, 296, 149, 54);
		btnJoin .setVisible(false);
		contentPane.add(btnJoin);
		
        addWindowListener(new WindowAdapter() {
        	public void windowOpened(WindowEvent e) {
        		Thread intro;
			    intro = new Thread(new Runnable(){
			    	public void run() {
				    	try {
				    		int i=0;           
				            while(i<=15){
				            	Text1.setLocation(Text1.getLocation().x+10,Text1.getLocation().y);
				                Thread.sleep(50);
				                i++;
				            }
				            Thread.sleep(1000);
				            Text2.setVisible(true);
				            while(i<=30) {
				            	Text2.setLocation(Text2.getLocation().x+10,Text2.getLocation().y);
				                Thread.sleep(50);
				                i++;
				            }
				            Thread.sleep(1000);
				            lblMergeSort.setVisible(true);
				            Mergetitle.setVisible(true);
				            Thread.sleep(1000);
				            lblSelectionSort.setVisible(true);
				            Seclectiontitle.setVisible(true);
				            Thread.sleep(1000);
				            lblBubbleSort.setVisible(true);
				            Bubbletitle.setVisible(true);
				            Thread.sleep(1000);
				            lblBucketSort.setVisible(true);
				            Buckettitle.setVisible(true);
				            Thread.sleep(1000);
				            ClickLabel.setVisible(true);
				            btnJoin.setVisible(true);
				            while(i<=35) {
				            	ClickLabel.setLocation(ClickLabel.getLocation().x, ClickLabel.getLocation().y+2);
				                btnJoin.setLocation(btnJoin.getLocation().x, btnJoin.getLocation().y+2);
				                Thread.sleep(20);
				                i++;
				            }
				    	}catch(Exception e){}
			    	}
			    });
			    intro.start();
			}
		});
	}
	
	public void backActionPerformed() {
		this.dispose();
		(new Welcome()).setVisible(true);
	}
}
