package garbageCollector;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 486);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Path of heap.csv \r\n");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		lblNewLabel.setBounds(11, 30, 184, 49);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBackground(SystemColor.window);
		textField.setBounds(205, 29, 378, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(205, 107, 378, 49);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(205, 191, 378, 49);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(205, 273, 378, 49);
		contentPane.add(textField_3);
		
		JLabel lblPathOfRootstxt_1 = new JLabel("Path of roots.txt\r\n\r\n");
		lblPathOfRootstxt_1.setFont(new Font("Consolas", Font.BOLD, 17));
		lblPathOfRootstxt_1.setBounds(10, 108, 184, 49);
		contentPane.add(lblPathOfRootstxt_1);
		
		JLabel lblPathOfRootstxt = new JLabel("Path of pointers.csv\r\n\r\n\r\n");
		lblPathOfRootstxt.setFont(new Font("Consolas", Font.BOLD, 17));
		lblPathOfRootstxt.setBounds(10, 192, 210, 49);
		contentPane.add(lblPathOfRootstxt);
		
		JLabel lblPathOfNewheapcsv = new JLabel("Path of new-heap.csv \r\n");
		lblPathOfNewheapcsv.setFont(new Font("Consolas", Font.BOLD, 17));
		lblPathOfNewheapcsv.setBounds(10, 274, 221, 49);
		contentPane.add(lblPathOfNewheapcsv);
		
		JLabel lblGarbageCollected = new JLabel("Garbage collected !!!");
		lblGarbageCollected.setForeground(Color.GREEN);
		lblGarbageCollected.setFont(new Font("Consolas", Font.BOLD, 17));
		lblGarbageCollected.setBounds(205, 391, 221, 49);
		contentPane.add(lblGarbageCollected);
		
		JButton btnNewButton = new JButton("run");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(253, 347, 116, 34);
		contentPane.add(btnNewButton);
	}
}
