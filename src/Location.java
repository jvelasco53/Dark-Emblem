import java.util.ArrayList;
import java.util.HashMap;

public class Location{
	private String locName;
	private String description;
	private ArrayList<Item> locItem;
	private HashMap<String, Item> itemsIn;
	private HashMap<String, Location> direction;
	private Character opponent;
	private Mp3Player mapMusic;

	
	
	public Location(String pLoc, String pLocDesc, String songName) {
		locName = pLoc;
		description = pLocDesc;
		itemsIn = new HashMap<String, Item>();
		locItem =  new ArrayList<Item>();
		direction = new HashMap<String, Location>();
		mapMusic = new Mp3Player(songName);

	}
	public void setOpponent(Character c) {
		opponent = c;
	}
	
	public Character getOpponent() {
		return opponent;
	}
	
	public void removeOpp() {
		opponent = null;
	}
	
	public String getOppName() {
		String ret = opponent.getName() + " - " + opponent.getDesc();
		return ret;
	}
	
	public void getOppStat() {
		System.out.print(opponent);
		System.out.println("\t" + "Reward Item: " + opponent.getDropItem().getName());
	}
	
	public void addDirection(String pDir, Location pLoc) {
		direction.put(pDir, pLoc);
	}
	
	public Location goDir(String pDir){
		if(direction.containsKey(pDir)) {
			return direction.get(pDir);
		}
		return null;
	}
	
	public String getLocName() {return locName;}
	public void setLocName(String locName) {this.locName = locName.toLowerCase();}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description.toLowerCase();}
	
	public void addItems(Item stuff) {
		locItem.add(stuff);
		itemsIn.put(stuff.getName().toLowerCase(), stuff);
	}
	
	public Item getItem(String sName) {	
		return itemsIn.get(sName.toLowerCase());
	}
	
	public int getNumOfItems() {
		return locItem.size();
	}
	
	public String getItemName(Item s) {return s.getName();}
	
	public Item getItemIndex(int index) {
		if(index < locItem.size()) {return locItem.get(index);}
		else {
			System.out.print("Doesn't have this Item in this location");
			return null;}}
	
	public void getAllName() {
		System.out.println("Items: ");
		for(Item i : locItem) {
			System.out.println("\t" + i.getName());}
	}

	
	public void removeItem(Item i) {
		locItem.remove(i);
		itemsIn.remove(i.getName());
	}
	
	public Container getContainer(String pName) {
		if(getItem(pName) instanceof Container) {
			return (Container)(getItem(pName));
		}
		return null;
	}
	
	public void playMP3() {
		mapMusic.play();
	}
	public void closeMP3() {
		mapMusic.close();
	}
}