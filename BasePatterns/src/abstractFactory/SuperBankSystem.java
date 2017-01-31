package abstractFactory;

import abstractFactory.banking.BankingTeamFactory;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getManager();

        System.out.println("Creating Bank System");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
