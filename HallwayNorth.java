package application;

public class HallwayNorth extends Room {

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "You are in North Hallway";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Hallway North";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new Bedroom(), new LivingRoom(), new Kitchen()};
	}

}
