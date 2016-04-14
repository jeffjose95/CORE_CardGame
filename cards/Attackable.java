package cards;

public interface Attackable {
    // defense should calculate elemental adjustment wherever applicable
    public int defend(Card attacker, int damage, boolean allowCounter);
    public void death(Card attacker);
    public boolean isDead();
}
