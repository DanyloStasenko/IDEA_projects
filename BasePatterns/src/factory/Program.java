package factory;

public class Program {

    public static void main(String[] args) {
        /*JavaDeveloper javaDeveloper = new JavaDeveloper();
        javaDeveloper.writeCode();
        CppDeveloper cppDeveloper = new CppDeveloper();
        cppDeveloper.writeCode();*/

        /*Developer developer = new CppDeveloper();
        developer.writeCode();
        DeveloperFactory developerFactory = new CppDeveloperFactory();
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();*/


        DeveloperFactory developerFactory = createDeveloperBySpeciality("php");
        Developer developer = developerFactory.createDeveloper();

        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpeciality(String speciality){
        if(speciality.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        }
        else if(speciality.equalsIgnoreCase("c++")){
            return new CppDeveloperFactory();
        }
        else if(speciality.equalsIgnoreCase("php")){
            return new PhpDeveloperFactory();
        }
        else{
            throw new RuntimeException(speciality + "is unknown");
        }
    }
}