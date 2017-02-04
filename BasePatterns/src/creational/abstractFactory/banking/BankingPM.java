package creational.abstractFactory.banking;

import creational.abstractFactory.ProjectManager;

public class BankingPM implements ProjectManager{
    @Override
    public void manageProject() {
        System.out.println("PM is managing");
    }
}
