package behavioral.command;

public class Developer {
    Command insert;
    Command update;
    Command select;
    Command delete;

    public Developer(Command insert, Command update, Command select, Command delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }

    public void insertCommand(){
        insert.execute();
    }

    public void updateCommand(){
        update.execute();
    }

    public void deleteCommand(){
        delete.execute();
    }

    public void selectCommand(){
        select.execute();
    }
}