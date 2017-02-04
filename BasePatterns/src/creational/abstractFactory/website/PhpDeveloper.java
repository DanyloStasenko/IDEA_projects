package creational.abstractFactory.website;

import creational.abstractFactory.Developer;

public class PhpDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Php dev is coding");
    }
}
