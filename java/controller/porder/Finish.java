package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Finish extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish frame = new Finish();
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
	public Finish() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Member m=(Member)Tool.readFile("member.txt");
		Porder p=(Porder)Tool.readFile("porder.txt");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 414, 162);
		contentPane.add(scrollPane);
		
		JTextArea showReport = new JTextArea();
		scrollPane.setViewportView(showReport);
		
		showReport.setText("訂單完成"+"\n會員: "+m.getName()+"\n地址: "+m.getAddress()+"\n電話: "+m.getPhone()
		+"\n================================"+"\n購物明細"+
		"\nwatermelon:"+p.getWatermelon()+
		"\nbanana:"+p.getBanana()+
		"\napple:"+p.getApple()+
		"\npear:"+p.getPear()+
		"\npineapple:"+p.getPineapple()+
		"\n共:"+(p.getWatermelon()*500+p.getBanana()*350+p.getApple()*200+p.getPear()*350+p.getPineapple()*270)+"元");
		
		JLabel showMember = new JLabel("");
		showMember.setFont(new Font("新細明體", Font.PLAIN, 16));
		showMember.setBounds(10, 10, 414, 31);
		contentPane.add(showMember);
		showMember.setText("會員: "+m.getName());
		
		
		
		/**************************************************/
		
		JButton btnNewButton = new JButton("列印");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					showReport.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(243, 228, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回主選單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManger pordermanger=new PorderManger();
				pordermanger.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(94, 228, 102, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Finish.class.getResource("/controller/images.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);

	}

}
