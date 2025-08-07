package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Member;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PorderManger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManger frame = new PorderManger();
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
	public PorderManger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel showMember2 = new JLabel("");
		showMember2.setFont(new Font("新細明體", Font.PLAIN, 16));
		showMember2.setBounds(168, 35, 124, 36);
		contentPane.add(showMember2);
		
		Member m = (Member)Tool.readFile("member.txt");
		String show = "會員: "+m.getName();
		String show2 = m.getName()+"歡迎您";
		showMember2.setText(show2);
		
		/************************************************************************/
		
		
		JButton findAllPorder = new JButton("查詢訂單");
		findAllPorder.setBounds(168, 147, 87, 23);
		findAllPorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FindAllPorder findallporder = new FindAllPorder();
				findallporder.setVisible(true);
				dispose();

			}
		});
		contentPane.setLayout(null);
		contentPane.add(findAllPorder);
		
		JButton addPorder = new JButton("挑選商品");
		addPorder.setBounds(168, 97, 87, 23);
		addPorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddPorder addporder = new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		contentPane.add(addPorder);
		
		JButton btnNewButton = new JButton("登出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(168, 193, 85, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PorderManger.class.getResource("/controller/546dkmfadnvs.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
		
		
		
		

	}
}
