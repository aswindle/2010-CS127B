
public class MonsterSheet {
	
	private String name;
	private int initMod;
	private int speed;
	private int HP;
	private int AC;
	private int Ref;
	private int Fort;
	private int Will;
	private Attack melee;
	private Attack ranged;
	private Spell spell1;
	private Spell spell2;
	private Spell spell3;
	
	public MonsterSheet(String setName, int setHP, int setAC, int init, int speed, int ref, int fort, int will){
		name = setName;
		HP = setHP;
		AC = setAC;
		initMod = init;
		Ref = ref;
		Fort = fort;
		Will = will;
		speed = speed;
	}

	public void getInit() {
		int init = (int)(20*Math.random()+1 + initMod);
		System.out.println(name + "'s Init: " + init);
	}
	
	public void checkHP(){
		System.out.println(name + "'s HP: " + HP);
	}
	
	public void checkAC(){
		System.out.println(name + "'s AC: " + AC);
	}
	
	public void checkRef(){
		System.out.println( name + "'s Ref: " + Ref);
	}
	
	public void checkFort(){
		System.out.println( name + "'s Fort: " + Fort);
	}
	
	public void checkWill(){
		System.out.println( name + "'s Will: " + Will);
	}
	
	public void checkSpeed(){
		System.out.println( name + "'s Speed: " + speed);
	}

	public void setMelee(int vsAC, int numDie, int type, int constant) {
		melee = new Attack(vsAC, numDie, type, constant);
	}
	
	public void melee(){
		System.out.println(name + melee.swing());
	}

	public void setRanged(int vsAC, int numDie, int type, int constant) {
		ranged = new Attack(vsAC, numDie, type, constant);
	}
	
	public void ranged(){
		System.out.println(name + ranged.swing());
	}

	public void takeHit(int dmg) {
			HP-= dmg;
			if(HP<=0) System.out.println(name + " has been killed");
			else System.out.println(name + "'s HP: " + HP);
	}
	
	public boolean save(){
		double test = Math.random();
		if(test<.5) return false;
		else return true;
	}
	

}
