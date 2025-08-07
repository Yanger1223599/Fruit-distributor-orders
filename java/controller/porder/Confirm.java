package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Confirm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm frame = new Confirm();
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
	public Confirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea showPorder = new JTextArea();
		showPorder.setBounds(10, 39, 414, 169);
		contentPane.add(showPorder);
		
		JLabel showMember = new JLabel("");
		showMember.setFont(new Font("新細明體", Font.PLAIN, 16));
		showMember.setBounds(10, 6, 230, 23);
		contentPane.add(showMember);
		
		Porder p=(Porder)Tool.readFile("porder.txt");
		Member m=(Member)Tool.readFile("member.txt");
		
		showMember.setText("會員: "+m.getName());
		
		String show="你的水果:"+
		"\nwatermelon:"+p.getWatermelon()+
		"\nbanana:"+p.getBanana()+
		"\napple:"+p.getApple()+
		"\npear:"+p.getPear()+
		"\npineapple:"+p.getPineapple()+
		"\n共:"+(p.getWatermelon()*500+p.getBanana()*350+p.getApple()*200+p.getPear()*350+p.getPineapple()*270)+"元";
		
		
		showPorder.setText(show);
		
		/********************************************************************/
		
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new PorderServiceImpl().addPorder(p);
				
				Finish finish = new Finish();
				finish.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(247, 228, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddPorder addporder = new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(92, 228, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Confirm.class.getResource("/controller/text-space-beige-background-nude-pink.jpg")));
		lblNewLabel.setBounds(0, 6, 434, 255);
		contentPane.add(lblNewLabel);
		
		

	}
}
