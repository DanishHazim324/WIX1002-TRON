package game;

public abstract class Character {
    protected String name;
    protected int level = 1;
    protected double xp = 0;
    protected int lives;
    protected double speed;
    protected double handling;
    protected int discsOwned;

    // Requirement: XP from enemies based on difficulty
    public void gainXP(int amount) {
        if (this.level >= 99) return; // Requirement: Max level 99
        
        this.xp += amount;
        
        // Requirement: Custom leveling-up algorithm
        while (this.xp >= getRequiredXP()) {
            this.xp -= getRequiredXP();
            performLevelUp();
        }
    }

    // Requirement: Rapid early advancement for first 10 levels
    private int getRequiredXP() {
        if (this.level <= 10) {
            return this.level * 100; // Lower threshold
        }
        return this.level * 500; // Normal threshold
    }

    private void performLevelUp() {
        this.level++;
        
        // Requirement: +1 life every 10 levels
        if (this.level % 10 == 0) {
            this.lives += 1;
        }

        // Requirement: Additional disc slot every 15 levels
        if (this.level % 15 == 0) {
            this.discsOwned += 1;
        }

        // Check for Story and Character unlocks
        checkUnlocks();

        // Apply unique character growth
        applySpecificStats();
    }

    private void checkUnlocks() {
        switch (this.level) {
            case 5:
                System.out.println(">>> STORY UNLOCKED: Chapter 1 - The Arrival.");
                break;
            case 10:
                System.out.println(">>> NEW CHARACTER UNLOCKED: Kevin Flynn is now playable!");
                break;
            case 20:
                System.out.println(">>> STORY UNLOCKED: Chapter 2 - The Rise of Clu.");
                break;
            case 50:
                System.out.println(">>> ACHIEVEMENT: Veteran of the Grid! Final Story Chapter Unlocked.");
                break;
        }
    }

    // Abstract method to force unique growth for subclasses
    protected abstract void applySpecificStats();
}