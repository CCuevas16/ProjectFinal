package application;

public class Kitchen extends Room {

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "Kitchen";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Kitchen";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new HallwayNorth(), new Bathroom(), new FrontRoom()};
	}

}
