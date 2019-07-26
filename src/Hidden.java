
public class Hidden extends Hide{
	
	private String key;
	private BasicItem after;
	
	public Hidden(BasicItem pItem, String pKey) {
		super(pItem);
		key = pKey;
		after = pItem;
	}
	
	public String getName() {
		return "Cursed_" + after.getName() ;
	}
	
	public String getDesc() {
		return "You have to get a right scroll to uncurse this item.";
	}

	public String checkKey() {
		return key;
	}
	
	public BasicItem unlock() {
		return after;
	}
	
}
