
public class HiddenContainer extends HideContainer{
	private String key;
	private Container after;
	
	public HiddenContainer(Container item, String pKey) {
		super(item);
		key = pKey;
		after = item;
	}

	public String getName() {
		return "Locked_"+ after.getName();
	}
	public String getDesc() {
		return "You have to get the right key to unlock this item.";
	}
	
	public String checkKey() {
		return key;
	}
	
	public Container unlock() {
		return after;
	}
}