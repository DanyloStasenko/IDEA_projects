package structural.decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator{

    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String makeCodeReview(){
        return "Making Code Review";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}
