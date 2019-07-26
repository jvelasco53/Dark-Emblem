public class Character {
	private String name; //Name
	private String desc; //Description
	private int currHp; //Health point
	private int capHp;
	private int atk; //Attack
	private int def; //Defense
	private BasicItem item1;
	private BasicItem item2;
	private int baseHp;
	private int baseAtk;
	private int baseDef;
	private BasicItem dropItem;
	
	public Character(String pName, String pDesc, int pHp, int pAtk, int pDef) {
		name = pName;
		desc = pDesc;
		baseHp = pHp;
		baseAtk = pAtk; 
		baseDef = pDef;
		atk = pAtk; 
		def = pDef;
		currHp = pHp;
		capHp = pHp;
		item1 = null;
		item2 = null;
	}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getDesc() {return desc;}

	public void setDesc(String desc) {this.desc = desc;}

	public int getCapHp() {
		return capHp;
	}

	public void setCapHp() {
		if(getItem1()!=null) {
			if(item1.getAttribute().equals("hp")) {
				capHp = baseHp + item1.getStat();
				}
			}
		if(getItem2()!=null) {
			if(item2.getAttribute().equals("hp")) {
				capHp = baseHp + item2.getStat();
			}
		}
		if(getItem1()!=null && getItem2()!= null) {
			if(item1.getAttribute().equals("hp") && item2.getAttribute().equals("hp")) {
				capHp = baseHp + item1.getStat() + item2.getStat();
			}
		}
	}
	
	public int getCurrHp() {return currHp;}
	
	public void setCurrHp(int pHp) {
		currHp = pHp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk() {
		if(getItem1()!=null) {
			if(item1.getAttribute().equals("atk")) {
				atk = baseAtk + item1.getStat();
			}
		}
		if(getItem2()!=null) {
			if(item2.getAttribute().equals("atk")) {
				atk = baseAtk + item2.getStat();
			}
		}
		if(getItem1()!=null && getItem2()!= null) {
			if(item1.getAttribute().equals("atk") && item2.getAttribute().equals("atk")) {
				atk = baseAtk + item1.getStat() + item2.getStat();
			}
		}
	}

	public int getDef() {
		return def;
	}

	public void setDef() {
		if(getItem1()!=null) {
			if(item1.getAttribute().equals("def")) {
				def = baseDef + item1.getStat();
			}
		}
		if(getItem2()!=null) {
			if(item2.getAttribute().equals("def")) {
				def = baseDef + item2.getStat();
			}
		}
		if(getItem1()!=null && getItem2()!= null) {
			if(item1.getAttribute().equals("def") && item2.getAttribute().equals("def")) {
				def = baseDef + item1.getStat() + item2.getStat();
			}
		}
	}

	public BasicItem getItem1() {
		return item1;
	}

	public void setItem1(BasicItem item1) {
		this.item1 = item1;
	}

	public BasicItem getItem2() {
		return item2;
	}

	public void setItem2(BasicItem item2) {
		this.item2 = item2;
	}
	
	public BasicItem getDropItem() {
		return dropItem;
	}

	public void setDropItem(BasicItem dropItem) {
		this.dropItem = dropItem;
	}
	
	public void update(){
		setAtk();
		setDef();
		setCapHp();
	}
	
	public String toString() {
		return   name +":"
					   + "\n" + "\t" + "HP: " + currHp +"/" + capHp  
					   + "\n" + "\t" + "Attack: " + atk
					   + "\n" + "\t" + "Defense: " + def
					   + "\n" + "\t" + "Description: " + desc + "\n";
	}

}
