package abstractFactory.website;

import abstractFactory.ProjectManager;

public class WebsitePM implements ProjectManager{
    @Override
    public void manageProject() {
        System.out.println("PM is managing website");
    }
}
