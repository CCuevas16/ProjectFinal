package application;

public class LivingRoom extends Room{

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "You are in Living Room";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Living Room";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new BedroomStart(), new HallwayNorth(), new HallwaySouth(), new Bathroom()};
	}

}
