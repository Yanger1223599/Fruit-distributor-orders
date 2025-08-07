package service;

import java.util.List;

import model.Porder;

public interface PorderService {

	//create
		void addPorder(Porder porder);
		
	//read
		List<Porder> findAllPorder();
		boolean selectMember(int id ,String name);
		List<Porder> selectFind(String name);
	//update
		boolean updatePorder(Porder porder);
		
	//delete
		boolean deletePorder(Porder porder);
	
}
