package GamePlay;

public class Magic_Phase implements Phase{
 Battle_Phase battlePhase = new Battle_Phase();
	@Override
	public Phase nextPhase() {
		return battlePhase;
	}

	@Override
	public boolean isThereAWinner() {
		// TODO Auto-generated method stub
		return false;
	}

}
