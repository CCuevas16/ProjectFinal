package application;

public class Bathroom extends Room{

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "You are in Bathroom";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Bathroom";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new Kitchen(), new LivingRoom()};
	}

}
