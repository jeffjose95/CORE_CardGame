package GamePlay;

public class Battle_Phase implements Phase {
 Player_Phase playerPhase = new Player_Phase();
	@Override
	public Phase nextPhase() {
		// TODO Auto-generated method stub
		return playerPhase;
	}

	@Override
	public boolean isThereAWinner() {
		// TODO Auto-generated method stub
		return false;
	}

}
