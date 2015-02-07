package game.entity;

public class Monster {
	//Represents monsters in the Magic Realm
	
	private String name;
	private String size;
	private boolean alerted;
	private boolean armoured;
	
	//Unalerted combat values
	private char unalertedHarm;
	private int  unalertedAttackSpeed;
	private int  unalertedMoveSpeed;
	
	//Alerted combat values
	private char alertedHarm;
	private int  alertedAttackSpeed;
	private int  alertedMoveSpeed;
	
	public Monster(String mName, String s, char uH, int uAS, int uMS, char aH, int aAS, int aMS, 
				   boolean iA){
		
		name = mName;
		size = s;
		
		unalertedHarm = uH;
		unalertedAttackSpeed = uAS;
		unalertedMoveSpeed = uMS;
		
		alertedHarm = aH;
		alertedAttackSpeed = aAS;
		alertedMoveSpeed = aMS;
		
		armoured = iA;
		alerted = false;
	}
	
	public String getName()        { return name; }
	public char getUnalertedHarm() { return unalertedHarm; }
	public int  getUnalertedAS()   { return unalertedAttackSpeed; }
	public int  getUnalertedMS()   { return unalertedMoveSpeed; }
	public char getAlertedHarm()   { return alertedHarm; }
	public int  getAlertedAS()     { return alertedAttackSpeed; }
	public int  getAlertedMS()     { return alertedMoveSpeed; }
	public String  getSize()       { return size; }
	
	public void setAlerted(boolean newState){ alerted = newState; }
	
	public boolean isAlerted() 	   { return alerted; }
	public boolean isArmoured()    { return armoured; }
}