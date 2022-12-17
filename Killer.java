package application;

import java.util.ArrayList;
import java.util.Random;

public class Killer  {
	
	private static Room currentRoom;
	
	public static void startGame() {
		currentRoom = new FrontRoom();
	}
	
	public static void moveToNextRoom() {
		Room[] allRooms = currentRoom.getNextRooms();
		ArrayList<Room> validRooms = new ArrayList<Room>();
		
		for(int i = 0; i < allRooms.length; i++) {
			Room room = allRooms[i];
			if(room.checkCanKillerMoveTo()) {
				validRooms.add(room);
			}
		}
		
		Random random = new Random();
		int roomIndex = random.nextInt(validRooms.size());
		currentRoom = validRooms.get(roomIndex);
	}
	
	public static boolean checkIfKillerInRooms(Room[] rooms) {
		if(rooms == null || rooms.length == 0) {
			return false;
		}
		
		for(int i = 0; i < rooms.length; i++) {
			if( rooms[i].getRoomName() == currentRoom.getRoomName()) {
				return true;
			}
		}
		
		return false;
		
	}

}
