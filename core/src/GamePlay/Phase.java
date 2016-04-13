package GamePlay;

public interface Phase {
	Phase nextPhase();
	
	boolean isThereAWinner();

}
