package structural.decorator;

public class JavaTeamLead extends DeveloperDecorator{
    public JavaTeamLead(Developer developer) {
        super(developer);
    }

    public String sendWeekReport(){
        return "Sending report";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}
