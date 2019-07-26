
public class BasicItem implements Item{
	private String shortName;
	private String type;
	private char rank;
	private String stats;
	private String desc;
	 
	public BasicItem(String pName, String pType, char pRank, String pStats, String pDesc) {
		shortName = pName;
		type = pType;
		rank = pRank;
		stats = pStats;
		desc = pDesc;
	}
	
	public void setName(String pName) {shortName = pName;}
	public void setType(String pType) {type = pType;}
	public void setRank(char pRank) {rank = pRank;}
	public void setStats(String pStats) {stats = pStats;}
	public void setDesc(String pDesc) {desc = pDesc;}
	
	public String getName() {return shortName;}
	public String getType() {return type;}
	public char getRank() {return rank;}
	public String getStats() {return stats;}
	public String getDesc() {return desc;}
	
	public String toString() {
		return  "\n" +"\t" + "Name: " + shortName 
					   + "\n" + "\t" + "Rank: " + rank
					   + "\n" + "\t" + "Stats: " + stats
					   + "\n" + "\t" + "Description: " + desc + "\n";
	} //"Item:" + 
	
	public String getAttribute() {
		String[] split = getStats().split(" ");
		if(split[0].equals("ATK")) {
			return "atk";
		}
		else if(split[0].equals("DEF")) {
			return "def";
		}
		return "hp";
	}
	
	public int getStat() {
		String[] split = getStats().split(" ");
		int stat = Integer.parseInt(split[1]);
		return stat;
	}
}