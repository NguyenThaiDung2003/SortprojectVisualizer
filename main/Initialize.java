package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Initialize extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JButton btnCreate;
	private JButton btnClaim;
	private JSpinner spAmount;
	private JSpinner[] spArray;
	private int amount;
	private int[] array;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initialize frame = new Initialize();
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
	public Initialize() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 556, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblAmount.setBounds(49, 32, 117, 51);
		contentPane.add(lblAmount);
		
		spAmount = new JSpinner();
		spAmount.setModel(new SpinnerNumberModel(2, 2, 10, 1));
		spAmount.setFont(new Font("Rockwell", Font.PLAIN, 20));
		spAmount.setBounds(214, 39, 117, 37);
		contentPane.add(spAmount);
		
		JLabel lblLimit = new JLabel("(from 2 to 10)");
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblLimit.setBounds(49, 68, 117, 25);
		contentPane.add(lblLimit);

		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createArray();
			}
		});
		btnCreate.setForeground(new Color(255, 0, 0));
		btnCreate.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCreate.setBackground(new Color(255, 255, 255));
		btnCreate.setBounds(382, 32, 117, 45);
		contentPane.add(btnCreate);
		
		btnClaim = new JButton("Claim");
		btnClaim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				claimArray();
			}
		});
		btnClaim.setForeground(new Color(255, 0, 0));
		btnClaim.setBackground(new Color(255, 255, 255));
		btnClaim.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnClaim.setBounds(214, 420, 117, 45);
		btnClaim.setEnabled(false);
		contentPane.add(btnClaim);
		
		spArray = new JSpinner[10];
		for(int i = 0; i < 10; i++) {
			spArray[i] = new JSpinner();
			spArray[i].setModel(new SpinnerNumberModel(0, 0, 100, 1));
			spArray[i].setFont(new Font("Rockwell", Font.PLAIN, 20));
			if(i == 0) spArray[i].setBounds(93, 128, 117, 37);
			else if(i < 5) spArray[i].setBounds(93, 128 + i * 55, 117, 37);
			else if(i == 5) spArray[i].setBounds(333, 128, 117, 37);
			else spArray[i].setBounds(333, 128 + (i - 5) * 55, 117, 37);
			contentPane.add(spArray[i]);
			spArray[i].setVisible(false);
		}
	}
	
	public Initialize(int[] initArray) {
		setLocationRelativeTo(null);
		setBounds(100, 100, 556, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblAmount.setBounds(49, 32, 117, 51);
		contentPane.add(lblAmount);
		
		spAmount = new JSpinner();
		spAmount.setModel(new SpinnerNumberModel(2, 2, 10, 1));
		spAmount.setFont(new Font("Rockwell", Font.PLAIN, 20));
		spAmount.setBounds(214, 39, 117, 37);
		contentPane.add(spAmount);
		
		JLabel lblLimit = new JLabel("(from 2 to 10)");
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblLimit.setBounds(49, 68, 117, 25);
		contentPane.add(lblLimit);

		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createArray();
			}
		});
		btnCreate.setForeground(new Color(255, 0, 0));
		btnCreate.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCreate.setBackground(new Color(255, 255, 255));
		btnCreate.setBounds(382, 32, 117, 45);
		contentPane.add(btnCreate);
		
		btnClaim = new JButton("Claim");
		btnClaim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				claimArray();
			}
		});
		btnClaim.setForeground(new Color(255, 0, 0));
		btnClaim.setBackground(new Color(255, 255, 255));
		btnClaim.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnClaim.setBounds(214, 420, 117, 45);
		btnClaim.setEnabled(false);
		contentPane.add(btnClaim);
		
		spArray = new JSpinner[10];
		for(int i = 0; i < 10; i++) {
			spArray[i] = new JSpinner();
			spArray[i].setModel(new SpinnerNumberModel(0, 0, 100, 1));
			spArray[i].setFont(new Font("Rockwell", Font.PLAIN, 20));
			if(i == 0) spArray[i].setBounds(93, 128, 117, 37);
			else if(i < 5) spArray[i].setBounds(93, 128 + i * 55, 117, 37);
			else if(i == 5) spArray[i].setBounds(333, 128, 117, 37);
			else spArray[i].setBounds(333, 128 + (i - 5) * 55, 117, 37);
			contentPane.add(spArray[i]);
			spArray[i].setVisible(false);
		}
		
		amount = initArray.length;
		array = initArray;
		spAmount.setValue(amount);
		spAmount.setEnabled(false);
		btnCreate.setEnabled(false);
		btnClaim.setEnabled(true);
		
		for(int i = 0; i < amount; i++) {
			spArray[i].setValue(initArray[i]);
			spArray[i].setVisible(true);
		}
		btnClaim.setEnabled(true);
	}
	
	public void createArray() {
		amount = (Integer) spAmount.getValue();
		for(int i = 0; i < amount; i++) {
			spArray[i].setVisible(true);
		}
		btnClaim.setEnabled(true);
	}
	
	public void claimArray() {
		array = new int[amount];
		for(int i = 0; i < amount; i++) {
			array[i] = (Integer) spArray[i].getValue();
		}
		Frame[] listFrame = Frame.getFrames();
		int frames = listFrame.length;
		for(int i = frames - 1; i >= 0; i--) if(listFrame[i] instanceof MainFrame) {
			((MainFrame) listFrame[i]).setArray(array);
			break;
		}
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	public int getAmount() {
		return amount;
	}

	public int[] getArray() {
		return array;
	}

}
