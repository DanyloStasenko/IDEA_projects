package abstractFactory.website;

import abstractFactory.Developer;

public class PhpDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Php dev is coding");
    }
}
