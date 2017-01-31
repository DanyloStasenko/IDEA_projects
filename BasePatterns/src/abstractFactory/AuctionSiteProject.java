package abstractFactory;

import abstractFactory.website.WebsiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebsiteTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getManager();

        System.out.println("Creating Auction Website");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
