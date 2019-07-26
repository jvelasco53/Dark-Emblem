/* THINGS_TO_DO AND NOTES
Check all the thing in checkpoint #1 and #2 again
Debugging all the error, try to make the program crash
*MIGHT BE REQUIRED* Adding an independent world() function to initialize the world. (Check again with Chad)
When examine the opponent, show stats and equipments, possible drop item and possible added stat.
We can choose if only the main character have equipment or all other characters have. 
A character can have 2 possible equipment, an armor and a weapon. Weapon alter ATK and AGI while
In a map, should have 2 mobs and 1 boss. Can only defeat final boss when defeat all the sub-boss. Final Map will be shown when defeat all the sub-boss.
In a battle, can only attack or flee (If free, will be penalty by take one attack). Add description of attack and flee.
Consumable Items can only consume when not in battle.
Sometimes, will have cursed(lock) item that can be open using a "key" which dropped when battle with an enemy.
Add music to the game.
Command to add: Consume 
Fix unlock to tranform. (cursed)
Consumables
Can remove the healing after winning

*OPTIONAL* Sometimes, open a chest will trigger an enemy, you have to fight that or flee after taking an attack.
*OPTIONAL* Create a cap for the stats. (Done with HP)
*OPTIONAL* Add to the help command how will the game work, what is the goal of the game,...
Ask Chad about how extra credit works. Does it contribute on the whole project and the checkpoint? also what will we get by adding a battle system.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;

public class Driver {

	public static void help() { //tell user to not enter a space, add command descriptions for commands that are not in these. 
		System.out.println("Command list and description: \n " + 
				" " + "Quit //Will end the game \n" +
				"  " + "Look //Will see what/who is on the current location \n" +
				"  " + "Go [player input direction] // will take you to a location \n" +
				"  " + "Examine [player input item name] //Examine an item \n" +
				"  " + "Unlock [player input item name] // Unlock an item using the right key stored in your inventory \n" +
				"  " + "Take [player input item name] //will take an item from the current location and place it in your inventory \n" + 
				"  " + "Drop [player input item name] //will drop the specified item in your inventory into the current location \n" + 
				"  " + "Take [player input item name] from [player input container name] //will take the item from the current location's container and add it to your inventory \n" +
				"  " + "Put [player input item name] in [player input container name] //will put the item you specified into a container you specified \n" +
				"  " + "Equip [player input item name] //will equip you with an equipment. There are 2 slots for you to equip equipment. If you equip item to a slot that is already filled, then the slot will update with the new item and put the old item in your bag \n" +
				"  " + "Battle // Will lock you in battle with the enemy and give you 2 options called Attack or Flee. If flee then player will take a strike from enemy \n" +
				"  " + "Enemy // Will give you the information about the enemy in the current location \n" +
				"  " + "Check //will give you the stats of your character, current equipments and a list of items that you have in your inventory (alternative of inventory command)  \n" + "\n" +
				"  " + "Possible directions for Go command: North, West, South, East, North-east, North-west, South-west, South-east");
	}
	
	
	
	public static void main(String[] args) {
		// Locations the game
		Location Sacae = new Location("Sacae", "Vast grasslands, home to various nomad tribes. You wake up here, having an amnesia.","1.mp3");
		Location Lycia = new Location("Lycia", "Home to several smaller territories, all who pledge allegiance to Ostia, the head of the League.", "2.mp3");
		Location Valor = new Location("Valor", "A small island off the main coast of Lycia. Deep within lies a great secret of the dragons, never seen before for almost a thousand years.", "4.mp3");
		Location Nabata = new Location("Nabata", "A huge desert, where the utopian village of Arcadia lies.", "5.mp3");
		Location Bern = new Location("Bern", "A militant land, ruled by King Desmond.", "6.mp3");
		Location Isles = new Location("Western Isles", "Fibernia, Caledonia and Dia. These islands are mostly inhabited by unruly pirates.", "7.mp3");
		Location Etruria = new Location("Etruria", "A prosperous land, said to be equal in strength to Bern.", "3.mp3");
		Location Ilia = new Location("Ilia", "A snowy and well-forested region. It is famous for its mercenary knights and female Pegasus riders.", "9.mp3");
		Location Kafti = new Location("Kafti", "An isolated, no man island to the south west. Known for being called \"The Hell\", the final boss holding the Dark Emblem stays here.", "secret.mp3" );
		Location Missur = new Location("Missur", "Mountainous area that lies next to the great desert Nabata. It is said the fortifications are so strong that none can invade it", "10.mp3");
		
		
		
		//Possible directions
		
			//Sacae directions=
		Sacae.addDirection("north", Ilia);
		Sacae.addDirection("west", Etruria);
		Sacae.addDirection("south", Bern);
		
			//Ilia directions
		Ilia.addDirection("south", Sacae);
		Ilia.addDirection("south-west", Etruria);
		
			//Bern directions
		Bern.addDirection("north", Sacae);
		Bern.addDirection("west", Lycia);
		Bern.addDirection("north-west", Etruria);
		Bern.addDirection("south-west", Valor);
		
			//Lycia directions
		Lycia.addDirection("east", Bern);
		Lycia.addDirection("north", Etruria);
		Lycia.addDirection("south", Valor);
		Lycia.addDirection("north-east", Sacae);
		Lycia.addDirection("south-west", Nabata);
		
			//Valor directions
		Valor.addDirection("north", Lycia);
		Valor.addDirection("west", Nabata);
		Valor.addDirection("north-east", Bern);
		
			//Nabata directions
		Nabata.addDirection("north", Isles);
		Nabata.addDirection("east", Valor);
		Nabata.addDirection("north-east", Lycia);
		
			//Isles directions
		Isles.addDirection("east", Etruria);
		Isles.addDirection("south", Nabata);
		Isles.addDirection("north-east", Ilia);
		
			//Etruria directions
		Etruria.addDirection("east", Sacae);
		Etruria.addDirection("south", Lycia);
		Etruria.addDirection("west", Isles);
		Etruria.addDirection("north-east", Ilia);
		Etruria.addDirection("south-west", Nabata);
		
			//Kafti directions
		Kafti.addDirection("north", Isles);
		Kafti.addDirection("east", Missur);
		Kafti.addDirection("north-east", Nabata);
		
			//Missur directions
		Missur.addDirection("north", Nabata);
		Missur.addDirection("west", Kafti);
		Missur.addDirection("east", Valor);
		
		
		//Item
			// Keys
			BasicItem key1 = new BasicItem("key1", "Key",'N',"None","First key to open locked item");
			BasicItem key2 = new BasicItem("key2", "Key",'N',"None","Second key to open locked item");
			//BasicItem Key3 = new BasicItem("Key3", "Key",'N',"None","Third key to open locked item");
			BasicItem key4 = new BasicItem("key4", "Key",'N',"None","Fourth key to open locked item");
			//BasicItem Key5 = new BasicItem("Key5", "Key",'N',"None","Fifth key to open locked item");
			BasicItem key6 = new BasicItem("key6", "Key",'N',"None","Sixth key to open locked item");
			BasicItem key7 = new BasicItem("key7", "Key",'N',"None","Seventh key to open locked item");
			
			//BasicItem itemloc1d= new BasicItem(" ", "KEY", 'D', "KEY7","A Slim Lance");
			//BasicItem itemloc3a = new BasicItem("IronLance", "KEY", 'E', "KEY1","Description");
			//BasicItem itemloc4b = new BasicItem("IronLance", "KEY", 'E', "KEY2","Description");
			
			//BasicItem itemloc5b = new BasicItem("IronLance", "KEY", 'E', "KEY3","Description");
			//BasicItem itemloc7a = new BasicItem("IronLance", "KEY", 'E', "KEY4","Description");
			//BasicItem itemloc8a = new BasicItem("IronLance", "KEY", 'E', "KEY5","Description");
			//BasicItem itemloc9a = new BasicItem("IronLance", "KEY", 'E', "KEY6","Description");
			
			BasicItem key5 = new BasicItem("kingslayer_scroll","Scroll",'N', "None","Scroll to uncurse the Kingslayer");
			BasicItem key3 = new BasicItem("duo_scroll","Scroll",'N', "None","Scroll to uncurse the Armorslayer and Basilikos");
	
			// Containers
			Container Chest = new Container("Chest", "The beginner chest");
			Container Sack = new Container("Sack", "This is the second bundle in Sacae");
			
			//Items
			BasicItem itemloc1a= new BasicItem("Slim_Lance", "Equipment", 'E', "ATK +5","Low damage lance but extremely accurate and light");
			BasicItem itemloc1b = new BasicItem("Iron_Shield", "Equipment", 'E', "DEF +4", "Low defense shield that is easy to wield");
			BasicItem shield = new BasicItem("First_Shield", "Equipment", 'D', "DEF +3", "First shield for the hero");

			BasicItem itemloc2a = new BasicItem("Steel_Shield", "Equipment", 'D', "DEF +6","Mediocre defense shield but harder to wield");
			BasicItem itemloc4a = new BasicItem("Steel_Sword", "Equipment", 'D', "ATK +15","Stronger than Iron but harder to wield");
			BasicItem itemloc5a = new BasicItem("Silver_Shield", "Equipment", 'C', "DEF +11","High defense shield but lighter");
			BasicItem itemloc6a = new BasicItem("Siver_Katana", "Equipment", 'C', "ATK +18","Stronger than Steel but lighter");
			BasicItem emblem = new BasicItem("Dark_Emblem", "Legendary", 'X'," Infinite ATK DEF HP"," The legendary Dark Emblem");
			BasicItem scroll = new BasicItem("Scroll","Scroll",'X',"None","Thank you for playing the game.");
			BasicItem chest6a = new BasicItem("Hero_Axe","Equipment",'S',"ATK +37","Axe for hero");
			BasicItem chest9a = new BasicItem("Brave_Axe","Equipment",'A',"ATK +19","Axe for brave adventurer");
			BasicItem chest9b = new BasicItem("Brave_Shield","Equipment",'A',"DEF +19","Shield for brave adventurer");


			//Cursed items
			Hidden hiddenloc6a = new Hidden(new BasicItem("Kingslayer","Equipment", 'S',"ATK +34", "A sword effective against king"), "kingslayer_scroll");
			Hidden hiddenloc9a = new Hidden(new BasicItem("Armorslayer","Equipment", 'A',"ATK +21", "A sword effective against armored enemy"), "duo_scroll");
			Hidden hiddenloc9b = new Hidden(new BasicItem("Basilikos","Equipment", 'A',"DEF +21", "For experienced hero only"), "duo_scroll");
			//Hidden hiddenloc10a = new Hidden(new BasicItem("ManiKatti","Scroll", 'X',"None", "A scroll"), "KeySword");
			
			//cursed container
			HiddenContainer lockedloc1a = new HiddenContainer(new Container("Chest1", "A chest that has been cursed for a century"), "Key4");
			HiddenContainer lockedloc5a = new HiddenContainer(new Container("Chest2", "A chest that has been cursed for a century"), "Key1");
			HiddenContainer lockedloc6a = new HiddenContainer(new Container("Chest3", "A chest that has been cursed for a century"), "Key6");
			HiddenContainer lockedloc9a = new HiddenContainer(new Container("Chest4", "A chest that has been cursed for a century"), "Key2");
			HiddenContainer lockedloc10a = new HiddenContainer(new Container("Chest5", "A chest that has been cursed for a century"), "Key7");
			
		// Player
		Character main = new Character("You", "Main Character", 40, 4, 0);
		Container myInv = new Container("Inventory", "This is the inventory of the hero, which include:");
		Location myLoc = Sacae;
		
		//Debug
		myInv.addItems(key1);
		myInv.addItems(key2);
		myInv.addItems(key3);
		myInv.addItems(key4);
		myInv.addItems(key5);
		myInv.addItems(key6);
		myInv.addItems(key7);
		myInv.addItems(itemloc4a);
		myInv.addItems(itemloc5a);
		myInv.addItems(itemloc6a);
		myLoc = Ilia;
		//Character
		
	    Character loc1 = new Character("Lyn", "First Opponent in Sacae", 40, 6, 2);
		Character loc2 = new Character("Lucius", "Opponent in Lycia", 40, 7, 1);
		Character loc3 = new Character("Raven", "Opponent in Bern", 40, 8, 5);
		Character loc4 = new Character("Isadora", "Opponent in Isles", 40, 12, 7);
		Character loc5 = new Character("Pent", "Opponent in Ilia", 40, 18, 11);
		Character loc6 = new Character("Harken", "Opponent in Etruria", 40, 16, 13);
		Character loc7 = new Character("Hawkeye", "Opponent in Missur", 40, 18, 14);
		Character loc8 = new Character("Lucius-reborn", "Lucius reborn to fight you in Valor", 40, 16, 16);
		Character loc9= new Character("El-Dyron", "Opponent in Nabata ", 30, 30, 20);
		Character Boss = new Character("Faker", "Final boss", 50, 35, 24);
		
		loc1.setDropItem(itemloc1b);
		loc2.setDropItem(itemloc2a);
		loc3.setDropItem(key1);
		loc4.setDropItem(key2);
		loc5.setDropItem(key3);
		loc6.setDropItem(itemloc6a);
		loc7.setDropItem(key4);
		loc8.setDropItem(key5);
		loc9.setDropItem(key6);
		Boss.setDropItem(emblem);
		
		
		// Set Characters
		Sacae.setOpponent(loc1);
		Lycia.setOpponent(loc2);
		Valor.setOpponent(loc8);
		Nabata.setOpponent(loc9);
		Bern.setOpponent(loc3);
		Isles.setOpponent(loc4);
		Etruria.setOpponent(loc6);
		Ilia.setOpponent(loc5);
		Kafti.setOpponent(Boss);
		Missur.setOpponent(loc7);
		
		// Set Items
		Sacae.addItems(lockedloc1a);
		Chest.addItems(itemloc1a);
		Chest.addItems(shield);

		Sacae.addItems(Chest);
		lockedloc1a.unlock().addItems(key7);
		
		Isles.addItems(Sack);
		Sack.addItems(itemloc4a);
		
		lockedloc5a.unlock().addItems(itemloc5a);
		Ilia.addItems(lockedloc5a);
		
		Etruria.addItems(lockedloc6a);
		lockedloc6a.unlock().addItems(chest6a);
		Etruria.addItems(hiddenloc6a);
		
		Nabata.addItems(lockedloc9a);
		lockedloc9a.unlock().addItems(chest9a);
		lockedloc9a.unlock().addItems(chest9b);
		Nabata.addItems(hiddenloc9a);
		Nabata.addItems(hiddenloc9b);
		
		Kafti.addItems(lockedloc10a);
		lockedloc10a.unlock().addItems(scroll);		
		
		// Music
		Mp3Player intro = new Mp3Player("intro.mp3");
		intro.play();

		
		// Add the picture of the map
		JFrame frame = new JFrame();
		frame.add(new JLabel(new ImageIcon("Map.jpg")));
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.pack();
		
		System.out.println("Welcome to Dark Emblem!");
		System.out.println("The main mission of the game is to defeat enemies and gather equipments to help you with the journey to defeat final boss Faker and get the Dark Emblem back");
		
		
		//Main Program
		while(true) {
			try {
				System.out.println();
				System.out.println("Location order suggestion: Sacae -> Lycia -> Bern -> Isles -> Ilia -> Etruria -> Missur -> Valor -> Nabata -> Kafti (Final Location)");
				System.out.println("If you need help with commands enter the command \"Help\"");
				System.out.println();
				System.out.print("Enter command (please enter command with no extra space before, in between and in the end): ");
				BufferedReader buf=new BufferedReader(new InputStreamReader(System.in)); //use BufferedReader to read the input user enter
				String[]  command = buf.readLine().toLowerCase().split(" "); //split command into each word
				
				//---Go---//
				if(command[0].equals("go") && command.length==2) {
					Location temp = myLoc.goDir(command[1]);
					if(temp == null) {
						System.out.println("You cannot go to this direction from this area.");
					}
					else {
						intro.close();
						myLoc.closeMP3();
						temp.playMP3();
						myLoc = temp;
						System.out.println("You have entered " +  myLoc.getLocName() + ".");
					}
					
				}
				
				//---Unlock---//
				else if(command[0].equals("unlock") && command.length==2) {
					Item i = myLoc.getItem(command[1]);
					if (i instanceof Hidden ) {
						Hidden h = (Hidden)(i);
						if(myInv.whether(h.checkKey().toLowerCase()) == true) {
							BasicItem i2 = h.unlock();
							
							System.out.println("Item unlocked using the key provided.");
							System.out.println("The item is: " + i2.getName() + " - " + i2.getDesc());
							
							myLoc.removeItem(h);
							myLoc.addItems(i2);
							myInv.removeString(h.checkKey().toLowerCase());
						}
						else 
							System.out.println("There are no items in your inventory that can unlock this item");
					}
					else if(i instanceof HiddenContainer) {
						HiddenContainer h = (HiddenContainer) i;
						if(myInv.whether(h.checkKey().toLowerCase()) == true) {
							BasicItem i2 = h.unlock();
							
							System.out.println("Item unlocked using the key provided.");
							System.out.println("The item is: " + i2.getName() + " - " + i2.getDesc());
							
							myLoc.removeItem(h);
							myLoc.addItems(i2);
							myInv.removeString(h.checkKey().toLowerCase());
						}
						else 
							System.out.println("There are no items in your inventory that can unlock this item");
					}
					else if(i != null) {
						System.out.println("This item is not locked");
					}
					else
						System.out.println("There exist no item with that name in this location.");
				}
				//---Quit---//
				else if(command[0].equals("quit") && command.length==1){
					System.out.println("You just quit the game. Thank you for playing.");
					System.exit(0);}
				
				//---Look---// 
				else if(command[0].equals("look") && command.length==1) {
					System.out.println("Current location: ");
					System.out.println("\t" + myLoc.getLocName() + " - " + myLoc.getDescription() );
					if(myLoc.getOpponent()!= null) {
						System.out.println("Enemy in the map: ");
						System.out.println("\t"+ myLoc.getOppName());
					}
					myLoc.getAllName();
				}
				
				//---Examine---// 
				else if(command[0].equals("examine") && command.length==2) {
					Item t = myLoc.getItem(command[1]);
					if(t != null) {
						System.out.println(t.getDesc());}
					else {
						System.out.println("There exist no item with that name in this location.");}}
				
				//---Take---// 
				else if(command[0].equals("take") && command.length==2) {
					String[] checkLock =command[1].split("_");
					
					if(checkLock[0].equals("locked") || checkLock[0].equals("cursed")) {
						System.out.println("You cannot add locked or cursed item to your inventory.");
					}
					else if (myLoc.getItem(command[1]) != null){
						Item i = myLoc.getItem(command[1]);
						myLoc.removeItem(i);
						myInv.addItems(i);
						System.out.println(i.getName() + " has been added to your inventory.");
					}
					else {
						System.out.println("There exist no item with that name in this location.");
					}
						
				}
				
				//---Check---//
				else if(command[0].equals("check") && command.length==1) {
					System.out.println(main);
					
					System.out.print("Equipment: ");
					System.out.println("\n" + "\t" + "Slot 1: " + main.getItem1());
					System.out.println("\n" + "\t" + "Slot 2: " + main.getItem2());
					
					if(myInv.counter()==0) {
						System.out.println("There is no item in your inventory.");
					}
					else
						System.out.println(myInv.getDesc());
				}
				
				//---Equip---// 
				else if(command[0].equals("equip") && command.length==2) {
					if(myInv.whether(command[1]) == true) {
						BasicItem i = (BasicItem) myInv.removeString(command[1]);
						if(i.getType().equals("Equipment")){
							System.out.print("Do you want to equip the item to the first slot or the second slot? Enter \"1\" or \"2\": ");
							BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
							String uInput = input.readLine();
							
							if (uInput.equals("1") ) {
								if(main.getItem1() != null) {
									myInv.addItems(main.getItem1());
									main.setItem1(i);
									System.out.println("You have equipped the item to the first slot.");
									main.update();
								}
								else{main.setItem1(i);
								System.out.println("You have equipped the item to the first slot.");
								main.update();
								}
							}
							
							else if (uInput.equals("2")) {
								if(main.getItem2() != null) {
									myInv.addItems(main.getItem2());
									main.setItem2(i);
									System.out.println("You have equipped the item to the second slot.");
									main.update();
								}
								else{main.setItem2(i);
								System.out.println("You have equipped the item to the second slot.");
								main.update();
								}
							}
							else if (!uInput.equals("2") || !uInput.equals("1") || uInput.equals(null)) { 
								System.out.println("Please enter a valid value.");
								myInv.addItems(i);
							}	
						}
						else {
							System.out.println("The item you entered is not an equipment.");
							myInv.addItems(i);
						}
					}
					else {
						System.out.println("There exist no item with that name in your inventory.");
					}
				}
				
				
				//---Drop---//
				else if (command[0].equals("drop") && command.length==2) {
					if(myInv.whether(command[1]) == true) {
						Item i = myInv.removeString(command[1]);
						myInv.removeString(command[1]);
						System.out.println(i.getName() + " has been removed from your inventory.");
					}
					else
						System.out.println("There exist no item with that name in your inventory.");
				}
				
				//---Take-From---//
				else if(command[0].equals("take") && command.length==4 && command[2].equals("from") ) {
					String[] checkLock =command[1].split("_");
					
					if(checkLock[0].equals("locked") || checkLock[0].equals("cursed")) {
						System.out.println("You cannot add locked or cursed item to your inventory.");
					}

					else if (myLoc.getContainer(command[3]) != null) {
						Container c = myLoc.getContainer(command[3]);
						if(c.whether(command[1]) == true) {
							Item i = c.removeString(command[1]);
							myInv.addItems(i);
							c.removeString(command[1]);
							System.out.println( i.getName() + " has been added to your inventory.");
						}
						else
							System.out.println("There exist no item with that name in the " + command[3] + ".");		
					}
					else 
						System.out.println("There exist no " + command[3] + " in the current area.");
				}
				
				//---Put-In---//	
				else if(command[0].equals("put") && command.length==4 && command[2].equals("in") ) {
					if (myLoc.getContainer(command[3]) != null) {
						Container c = myLoc.getContainer(command[3]);
						if(myInv.whether(command[1]) == true) {
							Item i = myInv.removeString(command[1]);
							myInv.removeString(command[1]);
							c.addItems(i);
							System.out.println( i.getName() + " has been added to " + command[3]+ " from your inventory.");
						}
						else
							System.out.println("There exist no item with that name in your inventory.");
					}
					else 
						System.out.println("There exist no " + command[3] + " in the current area.");
				}
				
				//---Enemy---// Fix if more than one enemy
				else if(command[0].equals("enemy") && command.length == 1) {
					if(myLoc.getOpponent()!=null) {
						myLoc.getOppStat();
					}
					else {
						System.out.println("You have already defeated the enemy in the area");
					}
				}
				
				//---Battle---// Fix if more than one enemy
				else if(command[0].equals("battle") && command.length == 1) {
					if(myLoc.getOpponent() != null) {
						System.out.println("You have entered the battle with " + myLoc.getOppName());
						
						while(true) {
							if(main.getCurrHp()<=0 || myLoc.getOpponent().getCurrHp()<=0) {
								if(main.getCurrHp() <=0) {
									System.out.println("Battle ended. You lose. Please try again.");
									System.exit(0);
								}
								else if(myLoc.getOpponent().getCurrHp()<=0) {
									System.out.println("Battle ended. You win. You got the reward item: ");
									System.out.println(myLoc.getOpponent().getDropItem());
									myInv.addItems(myLoc.getOpponent().getDropItem());
									myLoc.removeOpp();
									main.setCurrHp(main.getCapHp()); //heal all HP
									break;
								}
							}
							else {
								myLoc.getOppStat();
								System.out.println(main);
							
							System.out.print("What do you want to do? 1 - Attack, 2 - Flee. Enter \"1\" or \"2\": ");
							BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
							String uInput = input.readLine();
							if(uInput.equals("1")) {
								main.setCurrHp(main.getCurrHp() - (myLoc.getOpponent().getAtk() - main.getDef()));
								myLoc.getOpponent().setCurrHp(myLoc.getOpponent().getCurrHp() - (main.getAtk() - myLoc.getOpponent().getDef()));

								}
							else if(uInput.equals("2")) {
								main.setCurrHp(main.getCurrHp() - (myLoc.getOpponent().getAtk() - main.getDef()));
								System.out.println("You fled after taking a strike from your opponent. Remaining HP: " + main.getCurrHp() + "/" + main.getCapHp());
								break;
							}
							else if(!uInput.equals("2") || !uInput.equals("1") || uInput.equals(null)) {
								System.out.println("Please enter a valid value");
							}
							}
						}
					}
					else {
						System.out.println("You have already defeated the enemy in this area.");
					}
				}
				
				
				//---Help---// 
				else if(command[0].equals("help") && command.length == 1) {
					help();
				}
				
				else{
					System.out.println("Invalid command.");}				
			}		
			
			catch(Exception e){
				System.out.println(e);
				break;
			}
		}
	}
}
