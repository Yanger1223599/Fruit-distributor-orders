package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService{

	public static void main(String[] args) {
		
	}

	
	private static PorderDaoImpl pdi = new PorderDaoImpl();
	
	
	@Override
	public void addPorder(Porder porder) {
		
		pdi.add(porder);
		
	}

	@Override
	public List<Porder> findAllPorder() {
		// TODO Auto-generated method stub
		return pdi.selectAll();
	}

	@Override
	public boolean updatePorder(Porder porder) {
		
		Porder p = pdi.selectById(porder.getId());
		boolean x = false;
		if(p!=null)
		{
			x=true;
			pdi.update(porder);
		}
		
		return x;
	}

	@Override
	public boolean deletePorder(Porder porder) {
		
		Porder p = pdi.selectById(porder.getId());
		boolean x = false;
		if(p!=null)
		{
			x=true;
			pdi.delete(porder);
		}
		
		return x;
	}

	@Override
	public boolean selectMember(int id, String name) {
		// TODO Auto-generated method stub
		return pdi.selectMember(id, name);
	}

	@Override
	public List<Porder> selectFind(String name) {
		// TODO Auto-generated method stub
		return pdi.selectFind(name);
	}


	
}
	