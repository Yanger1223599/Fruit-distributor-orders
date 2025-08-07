package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AddPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField watermelon;
	private JTextField banana;
	private JTextField apple;
	private JTextField pear;
	private JTextField pineapple;
	private JLabel showMember;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorder frame = new AddPorder();
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
	public AddPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("watermelon");
		lblNewLabel.setBounds(90, 44, 73, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("banana");
		lblNewLabel_1.setBounds(90, 80, 73, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("apple");
		lblNewLabel_2.setBounds(90, 115, 73, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("pear");
		lblNewLabel_3.setBounds(95, 150, 46, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("pineapple");
		lblNewLabel_4.setBounds(90, 189, 73, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("500元");
		lblNewLabel_5.setBounds(290, 44, 46, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("350元");
		lblNewLabel_6.setBounds(290, 80, 46, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("200元");
		lblNewLabel_7.setBounds(290, 115, 46, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("350元");
		lblNewLabel_8.setBounds(290, 150, 46, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("270元");
		lblNewLabel_9.setBounds(290, 189, 46, 15);
		contentPane.add(lblNewLabel_9);
		
		
		watermelon = new JTextField();
		watermelon.setBounds(173, 41, 96, 21);
		watermelon.setText("0");
		contentPane.add(watermelon);
		watermelon.setColumns(10);
		
		banana = new JTextField();
		banana.setBounds(173, 77, 96, 21);
		banana.setText("0");
		contentPane.add(banana);
		banana.setColumns(10);
		
		apple = new JTextField();
		apple.setBounds(173, 112, 96, 21);
		apple.setText("0");
		contentPane.add(apple);
		apple.setColumns(10);
		
		
		
		pear = new JTextField();
		pear.setBounds(173, 147, 96, 21);
		pear.setText("0");
		contentPane.add(pear);
		pear.setColumns(10);
		
		pineapple = new JTextField();
		pineapple.setBounds(173, 186, 96, 21);
		pineapple.setText("0");
		contentPane.add(pineapple);
		pineapple.setColumns(10);
		
		showMember = new JLabel("");
		showMember.setFont(new Font("標楷體", Font.PLAIN, 16));
		showMember.setBounds(0, 0, 190, 44);
		contentPane.add(showMember);
		
		Member m = (Member)Tool.readFile("member.txt");
		String show = "會員: "+m.getName();
		
		showMember.setText(show);
		
		/************************************************************************/
		
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(249, 228, 87, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Watermelon = Integer.valueOf(watermelon.getText());
				int Banana = Integer.valueOf(banana.getText());
				int Apple = Integer.valueOf(apple.getText());
				int Pear = Integer.valueOf(pear.getText());
				int Pineapple = Integer.valueOf(pineapple.getText());
				
				Porder p=new Porder(m.getName(),Watermelon,Banana,Apple,Pear, Pineapple);
				Tool.saveFile(p, "porder.txt");
				
				Confirm confirm=new Confirm();
				confirm.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setBounds(103, 228, 87, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManger pordermanger=new PorderManger();
				pordermanger.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(AddPorder.class.getResource("/controller/shimmering-gold-moon-stars-pattern-watercolor.jpg")));
		lblNewLabel_10.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_10);
		

		
		
		
	}
}
