package com.the703.basic011_ex;

class MobileNote{


 //for(int i=7; i<=9; i++) {System.out.println("NOTE"+i+"객체기능"+"(Overriding)기능");}
	void Show() {
	}
}
class MobileNote7 extends MobileNote{
	private String iris,face;
	public String getIris() { return iris; }   public void setIris(String iris) { this.iris = iris; }
	public String getFace() { return face; }   public void setFace(String face) { this.face = face; }
	
	///생성자 오버로딩(이름이 같음 - 파라미터의 자료형과 갯수)
	public MobileNote7() { super();  }
	public MobileNote7(String iris, String face) {
		super(); this.iris = iris; this.face = face; }
	
	void newShow() {
		System.out.println("NOTE7 객체 기능(Overriding)\r\n"
				+ "iris =" +this.iris+"\n"
				+ "face =" +this.face+"\n");
	}
}
class MobileNote8 extends MobileNote7{ //상속시
	private String face;
	public String getFace() { return face; }  public void setFace(String face) { this.face = face; }
	
	//오버라이딩(상속시 부모의 메서드를 수정해서 자식클래스에 맞게 수정)
	@Override void newShow() {
		super.newShow();
		System.out.println("NOTE8 객체 기능(Overriding) 추가\r\n"
			+ "face ="+ this.face+"\n");}

}
class MobileNote9 extends MobileNote8{
	private int battery;
	public MobileNote9(String iris, String face, int battery) {
		this.setIris(iris);
		this.setFace(face);
		this.setBattery(battery);
		
	}

	public int getBattery() { return battery; }  public void setBattery(int battery) { this.battery = battery; }
	
	@Override void newShow() {
		super.newShow();
		System.out.println("NOTE9 객체 기능(Overriding) 추가\r\n"
				+ "battery 예쁘게 사용하기!\r\n"
				+ "battery ="+this.battery);
	}

}

public class ExtendsEx002 {
	public static void main(String[] args) {
		 MobileNote7 my7 = new MobileNote7();
//	        my7.setIris("brown");
//	        my7.setFace("brown");
//	        my7.newShow();
//
//	        MobileNote8 my8 = new MobileNote8();
//	        my8.setFace("pretty");
//	        my8.newShow();
//
//	        MobileNote9 my9 = new MobileNote9();
//	        my9.setBattery(24);
//	        my9.newShow();
		 MobileNote9 my9 = new MobileNote9("brown","pretty",24*7);
		 my9.newShow();

	}

}
