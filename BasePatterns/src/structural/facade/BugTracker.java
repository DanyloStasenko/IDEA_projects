package structural.facade;

public class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

   public void startSprint(){
       System.out.println("Starting sprint");
       activeSprint = true;
   }

    public void finishSprint(){
        System.out.println("Finishing sprint");
        activeSprint = false;
    }
}
