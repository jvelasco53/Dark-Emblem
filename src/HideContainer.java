
public class HideContainer implements Item {
	protected Container hidden;
	
	public HideContainer(Container s) {
		hidden = s;
	}

	@Override
	public String getName() {
		return hidden.getName();
	}

	@Override
	public String getDesc() {
		return hidden.getDesc() ;
	}
	
}