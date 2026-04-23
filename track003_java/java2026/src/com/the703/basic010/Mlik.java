package com.the703.basic010;

public class Mlik {
	  private int  mno;   
	   private String mname;  
	   private  int mprice;
	   
	   public int getMprice() { return mprice; }

	   public void setMprice(int mprice) { this.mprice = mprice; }

	   @Override public String toString() 
	   { return "Mlik [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]"; }
}
