
public class Hide implements Item{
	protected BasicItem hide;
	
	public Hide(BasicItem pItem) {
		hide = pItem;
	}
	
	@Override
	public String getName() {
		return hide.getName();
	}
	@Override
	public String getDesc() {
		return hide.getDesc();
	}
	
}
