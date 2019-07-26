import java.util.ArrayList;

public class Container extends BasicItem {
	private ArrayList<Item> container;
	
	public Container(String pName, String pDesc) {
		super(pName, "null", '0', "null", pDesc);
		container = new ArrayList<Item>();
	}
	
	public void addItems(Item i) {
		container.add(i);
	}
	
	public Item removeString(String pName) {
		for (Item i: container) {
			if(pName.equals(i.getName().toLowerCase())) {
				container.remove(i);
				return i;
			}
		}
		return null;
	}
	
	public Item removeIndex(int pIndex) {
		if(pIndex< container.size()) {
			Item temp = container.get(pIndex);
			container.remove(temp);
			return temp;
		}
		return null;
	}
	
	public int counter() {
		return container.size();
	}
	
	public boolean whether(String pName) {
		for(Item i: container) {
			if(pName.equals(i.getName().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public String getDesc() {
		String ret = super.getDesc();
		for(Item i: container) {
			ret += "\n" + "\t" + i.getName(); 
		}
		return ret;
	}
}
