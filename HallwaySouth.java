package application;

public class HallwaySouth extends Room{

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "You are in South Hallway";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Hallway South";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new LivingRoom(), new FrontRoom()};
	}

}
