package application;


public class BedroomStart extends Room {
	
	@Override
	protected String getLabel() {
		return "Someone has broken into your home while you were sleeping. You need to pick your next action and figure out a way out. Pick a room. You need to avoid the killer. Find a way out!";
	}

	@Override
	protected String getRoomName() {
		return "Bedroom";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return new Room[] {new HallwayNorth(), new LivingRoom()};
	}
	
	@Override
	protected boolean checkShouldMoveKiller() {
		return false;
	}
	
	@Override
	protected boolean checkCanKillerMoveTo() {
		return false;
	}
	
	

}
	