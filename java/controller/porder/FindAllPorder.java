package controller.porder;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FindAllPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField watermelon;
	private JTextField banana;
	private JTextField apple;
	private static  PorderServiceImpl psi=new PorderServiceImpl();
	private JTextField deleteID;
	private JTextField pear;
	private JTextField pineapple;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindAllPorder frame = new FindAllPorder();
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
	public FindAllPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Member m = (Member)Tool.readFile("member.txt");
		List<Porder> l=psi.selectFind(m.getName());
		String show="";
		int count=0; 
		int Watermelon=0;
		int Banana=0;
		int Apple=0;
		int Pear=0;
		int Pineapple=0;
		
		for(Porder p:l)
		{
			show=show+
					"id:"+p.getId()+"\tname:"+p.getName()+"\twatermelon:"+p.getWatermelon()+"\tbanana:"+p.getBanana()+"\tapple:"+p.getApple()+"\tpear:"+p.getPear()+"\tpineapple:"+p.getPineapple()+"\n";
			count++;
			Watermelon=Watermelon+p.getWatermelon();
			Banana=Banana+p.getBanana();
			Apple=Apple+p.getApple();
			Pear=Pear+p.getPear();
			Pineapple=Apple+p.getPineapple();
		}
		contentPane.setLayout(null);
		
		JLabel sum = new JLabel("");
		sum.setBounds(31, 151, 536, 73);
		contentPane.add(sum);
		int allsum = Watermelon*500+Banana*350+Apple*200+Pear*350+Pineapple*270;
		sum.setText("筆數:"+count+"    Watermelon:"+Watermelon+"    Banana:"+Banana+"    Apple:"+Apple+"    Pear:"+Pear+"    Pineapple:"+Pineapple+"     銷售總金額:"+allsum+"元");
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 203, 557, 87);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 23, 20, 15);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(40, 20, 51, 21);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Watermelon");
		lblNewLabel_1.setBounds(10, 62, 80, 15);
		panel.add(lblNewLabel_1);
		
		watermelon = new JTextField();
		watermelon.setBounds(82, 59, 32, 21);
		panel.add(watermelon);
		watermelon.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Banana");
		lblNewLabel_2.setBounds(119, 62, 51, 15);
		panel.add(lblNewLabel_2);
		
		banana = new JTextField();
		banana.setBounds(166, 59, 32, 21);
		panel.add(banana);
		banana.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apple");
		lblNewLabel_3.setBounds(208, 62, 46, 15);
		panel.add(lblNewLabel_3);
		
		apple = new JTextField();
		apple.setBounds(242, 59, 32, 21);
		panel.add(apple);
		apple.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pear");
		lblNewLabel_5.setBounds(284, 62, 46, 15);
		panel.add(lblNewLabel_5);
		
		pear = new JTextField();
		pear.setBounds(315, 59, 32, 21);
		panel.add(pear);
		pear.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Pineapple");
		lblNewLabel_6.setBounds(357, 62, 58, 15);
		panel.add(lblNewLabel_6);
		
		pineapple = new JTextField();
		pineapple.setBounds(425, 59, 32, 21);
		panel.add(pineapple);
		pineapple.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 557, 158);
		contentPane.add(scrollPane);
		
		
		JTextArea allporder = new JTextArea();
		scrollPane.setViewportView(allporder);
		allporder.setText(show);
		/****************************************************************/
		
		
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(248, 358, 87, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManger pordermanger=new PorderManger();
				pordermanger.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(467, 58, 80, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int ID = Integer.valueOf(id.getText());
				
				boolean b = psi.selectMember(ID, m.getName());
				
				if(b==true) 
				{
					int Watermelon = Integer.valueOf(watermelon.getText());
					int Banana = Integer.valueOf(banana.getText());
					int Apple = Integer.valueOf(apple.getText());
					int Pear = Integer.valueOf(pear.getText());
					int Pineapple = Integer.valueOf(pineapple.getText());
					Porder p = new Porder();
					p.setId(ID);
					p.setWatermelon(Watermelon);
					p.setBanana(Banana);
					p.setApple(Apple);
					p.setPear(Pear);
					p.setPineapple(Pineapple);
				
					psi.updatePorder(p);
					JOptionPane.showMessageDialog(null, "成功","成功",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "失敗","失敗1",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 306, 557, 43);
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(10, 13, 46, 15);
		panel_1.add(lblNewLabel_4);
		
		deleteID = new JTextField();
		deleteID.setBounds(66, 10, 46, 21);
		panel_1.add(deleteID);
		deleteID.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setBounds(385, 9, 80, 23);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int DELID=Integer.parseInt(deleteID.getText());
			
				boolean b = psi.selectMember(DELID, m.getName());
				
				if(b==true) 
				{
					Porder p=new Porder();
					p.setId(DELID);
				
					psi.deletePorder(p);
					JOptionPane.showMessageDialog(null, "成功","成功",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "失敗","失敗",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(FindAllPorder.class.getResource("/controller/abstract-frame-brown-with-memphis-illustrations-earth-tone.jpg")));
		lblNewLabel_7.setBounds(0, 0, 575, 389);
		contentPane.add(lblNewLabel_7);
		
		
		

	}
}
