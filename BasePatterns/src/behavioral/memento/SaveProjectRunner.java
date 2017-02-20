package behavioral.memento;

public class SaveProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();
        GithubRepo repo = new GithubRepo();

        System.out.println("Creating new project: v1.0");
        project.setVersion("v 1.0");

        System.out.println(project);

        System.out.println("Saving current version to Github");
        repo.setSave(project.save());

        System.out.println("Updating to 1.1");

        System.out.println("Writing code");

        project.setVersion("v. 2.0");

        System.out.println(project);

        System.out.println("Something went wrong");

        System.out.println("Rolling back to 1.0");
        project.load(repo.getSave());

        System.out.println("Rpoject after rollback:");
        System.out.println(project);

    }
}
