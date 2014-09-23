package model;

import java.io.*;
import java.util.*;

public class Blah implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date date;
	private String txt;
	
	public Blah(String name,Date date,String txt){
		this.name = name;
		this.date = date;
		this.txt = txt;
	}
	public Blah(){}
	
	public String getName(){
		return name;
	}
	
	public Date getDate(){
		return date;
	}
	
	public String getTxt(){
		return txt;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public void setTxt(String txt){
		this.txt = txt;
	}

}