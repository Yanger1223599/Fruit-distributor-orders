package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
		
		
		List<Porder> l= new PorderDaoImpl().selectFind("te");
		for (Porder o:l) 
		{
			System.out.print(o.getId());
		}
	}
	
	
	
	private static Connection con=DbConnection.getDb();
	
	
	@Override
	public void add(Porder porder) {
		String sql="insert into porder(name,watermelon,banana,apple,pear,pineapple) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,porder.getName());
			ps.setInt(2,porder.getWatermelon());
			ps.setInt(3,porder.getBanana());
			ps.setInt(4,porder.getApple());
			ps.setInt(5,porder.getPear());
			ps.setInt(6,porder.getPineapple());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		
		List<Porder> l = new ArrayList();
		try {
				
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			while(rs.next())
			{
				Porder p = new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setWatermelon(rs.getInt("Watermelon"));
				p.setBanana(rs.getInt("Banana"));
				p.setApple(rs.getInt("Apple"));
				p.setPear(rs.getInt("Pear"));
				p.setPineapple(rs.getInt("Pineapple"));
				
				l.add(p);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public Porder selectById(int id) {
		String sql="select * from porder where id=?";
		Porder p=null;
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setWatermelon(rs.getInt("Watermelon"));
				p.setBanana(rs.getInt("Banana"));
				p.setApple(rs.getInt("Apple"));
				p.setPear(rs.getInt("Pear"));
				p.setPineapple(rs.getInt("Pineapple"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return p;
	}

	
	
	@Override
	public void update(Porder porder) {
		String sql="update porder set watermelon=?,banana=?,apple=?,pear=?,pineapple=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,porder.getWatermelon());
			ps.setInt(2,porder.getBanana());
			ps.setInt(3,porder.getApple());
			ps.setInt(4,porder.getPear());
			ps.setInt(5,porder.getPineapple());
			ps.setInt(6, porder.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	@Override
	public void delete(Porder porder) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, porder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean selectMember(int id, String name) {
		// TODO Auto-generated method stub
		boolean b = false;
		String sql="select 1 from porder where id=? and name=?";
	
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			
			ResultSet rs=ps.executeQuery();
			
			b = rs.next();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Porder> selectFind(String name) {
		String sql="select * from porder where name=?";
		
		List<Porder> l = new ArrayList();
		try {
				
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet  rs = ps.executeQuery();
			while(rs.next())
			{
				Porder p = new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setWatermelon(rs.getInt("Watermelon"));
				p.setBanana(rs.getInt("Banana"));
				p.setApple(rs.getInt("Apple"));
				p.setPear(rs.getInt("Pear"));
				p.setPineapple(rs.getInt("Pineapple"));
				
				l.add(p);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}
	
	
}