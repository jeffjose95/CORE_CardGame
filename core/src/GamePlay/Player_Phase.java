package GamePlay;

public class Player_Phase implements Phase {
	Magic_Phase theMagicPhase = new Magic_Phase();

	@Override
	public Phase nextPhase() {
		return theMagicPhase;
	}

	@Override
	public boolean isThereAWinner() {
		// TODO Auto-generated method stub
		return false;
	}

}
