package behavioral.state;

public class DeveloperDayRunner {

    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer developer = new Developer();

        developer.setActivity(activity);

        for (int i = 0; i < 10 ; i++) {
            developer.schangeActivity();
            developer.justDoIt();
        }
    }
}
