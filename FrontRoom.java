package application;

public class FrontRoom extends Room {

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "This is the Front Door";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Front Room";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new HallwaySouth(), new Kitchen(), new Outside()};
	}

}
