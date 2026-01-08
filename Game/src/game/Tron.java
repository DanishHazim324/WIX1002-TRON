package game;

public class Tron extends Character {

    public Tron() {
        this.name = "Tron";
        // Initial stats will eventually be overwritten by File I/O
    }

    
    protected void applySpecificStats() {
        // Requirement: Tron gains more speed and stability per level
        this.speed += 1.5; 
        this.handling += 0.5; // Stability represented by handling
        
        System.out.println("Tron leveled up! Speed increased significantly.");
    }
}