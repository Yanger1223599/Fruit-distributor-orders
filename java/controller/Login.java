package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMember;
import controller.member.Forgetpassword;
import controller.member.LoginError;
import controller.porder.PorderManger;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("水果店");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(142, 10, 69, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(54, 55, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(54, 106, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(127, 52, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(127, 103, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		
		/********************************************************/
		
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				String Username = username.getText();
				String Password = password.getText();
				
				Member m=new MemberServiceImpl().login(Username, Password);
				
				if(m!=null)
				{
					Tool.saveFile(m,"member.txt");
					PorderManger pordermanger=new PorderManger();
					pordermanger.setVisible(true);
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
		btnNewButton.setBounds(250, 49, 87, 23);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddMember addmember = new AddMember();
				addmember.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(127, 142, 96, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("離開");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(127, 182, 96, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("忘記密碼");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Forgetpassword forgetpassword = new Forgetpassword();
				forgetpassword.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(250, 102, 87, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/controller/pngtree-pink-yellow-clouds-cute-baby-background-image_587296.jpg")));
		lblNewLabel_2.setBounds(0, 0, 367, 215);
		contentPane.add(lblNewLabel_2);
		

		

	}
}
