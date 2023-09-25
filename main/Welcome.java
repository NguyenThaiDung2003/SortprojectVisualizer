package main;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;

public class Welcome extends JFrame {
	private JPanel contentPane;
	private ImageIcon imgBackground;
	private static final long serialVersionUID = 1L;
	private JButton btnStart;
	private JButton btnIntroduce;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//luồng thực thi không đồng bộ
			public void run() {
				setLookandFeel();//thay đổi giao diện cho đẹp hơn
				try {
					Welcome welcomeFrame = new Welcome();  // tạo frame welcome
					welcomeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Welcome() {// phương thức khởi tạo
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);//không bị chặn bởi các modal dialog
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//thoát chương trình
		setExtendedState(JFrame.MAXIMIZED_BOTH);//set kick thươc
		setLocationRelativeTo(null);//căn giữa
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		imgBackground = new ImageIcon(Welcome.class.getResource("/image/background.png"));
		/*Sound intro = new Sound("intro.wav");
		intro.start();*/
		contentPane = new JPanel() {// tạo background
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {//vẽ background
				super.paintComponent(g);
				g.drawImage(imgBackground.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart = new JButton("START");//tạo nút start
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startActionPerformed();//tạo, mở mainframe
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnStart.setForeground(Color.GREEN);
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//set con trỏ chuột
		btnStart.setBackground(getForeground());
		btnStart.setBounds(125, 600, 200, 100);
		contentPane.add(btnStart);//thêm vào contentPane
		  
		btnIntroduce = new JButton("ABOUT");//tạo nút about
		btnIntroduce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIntroduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutActionPerformed();//tạo, mở introduce
			}
		});
		btnIntroduce.setForeground(Color.GREEN);
		btnIntroduce.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnIntroduce.setBackground((Color) null);
		btnIntroduce.setBounds(405, 600, 200, 100);
		contentPane.add(btnIntroduce);
		
		JLabel lblNewLabel = new JLabel("SORTING ALGORITHMS");//tạo label sorting algorithms
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 44));
		lblNewLabel.setBounds(92, 521, 661, 86);
		contentPane.add(lblNewLabel);
	}
	
	
	/*
	 * Set look and feel
	 */
	public static void setLookandFeel() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
	}
	
	public void startActionPerformed() {
		this.dispose();
		(new MainFrame()).setVisible(true);
	}
	
	public void aboutActionPerformed() {
		this.dispose();
		(new Introduce()).setVisible(true);
	}
}