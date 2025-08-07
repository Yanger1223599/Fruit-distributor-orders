package model;

import java.io.Serializable;

public class Porder implements Serializable{
	
	private int Id ;
	private String name;
	private int watermelon;
	private int banana;
	private int apple;
	private int pear;
	private int pineapple;

	
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Porder( String name, int watermelon, int banana, int apple, int pear, int pineapple) {
		super();
		
		this.name = name;
		this.watermelon = watermelon;
		this.banana = banana;
		this.apple = apple;
		this.pear = pear;
		this.pineapple = pineapple;
	}


	


	

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getWatermelon() {
		return watermelon;
	}


	public void setWatermelon(int watermelon) {
		this.watermelon = watermelon;
	}


	public int getBanana() {
		return banana;
	}


	public void setBanana(int banana) {
		this.banana = banana;
	}


	public int getApple() {
		return apple;
	}


	public void setApple(int apple) {
		this.apple = apple;
	}


	public int getPear() {
		return pear;
	}


	public void setPear(int pear) {
		this.pear = pear;
	}


	public int getPineapple() {
		return pineapple;
	}


	public void setPineapple(int pineapple) {
		this.pineapple = pineapple;
	}

}