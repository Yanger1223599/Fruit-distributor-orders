package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class Forgetpassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField name;
	private JTextField username;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Forgetpassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(54, 121, 46, 15);
		contentPane.add(lblNewLabel);
		
		
		
		username = new JTextField();
		username.setBounds(137, 118, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("名字");
		lblNewLabel_1.setBounds(54, 65, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(137, 62, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		
		/********************************************************/
		
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			

				String Name = name.getText();
				String Username = username.getText();
				
				Member m=new MemberServiceImpl().findUsernameMember(Name,Username);
				
				if(m!=null)
				{
					Tool.saveFile(m,"member.txt");
					FindPasswordMember findPasswordMember = new FindPasswordMember();
					findPasswordMember.setVisible(true);
					dispose();
				}
				else
				{
					LoginError loginerror = new LoginError();
					loginerror.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(205, 170, 96, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(66, 170, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Forgetpassword.class.getResource("/controller/iPca05wKd7.jpg")));
		lblNewLabel_2.setBounds(0, 0, 369, 215);
		contentPane.add(lblNewLabel_2);
		
		

	}
}
