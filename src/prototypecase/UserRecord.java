package src.prototypecase;

public class UserRecord  extends DatabaseRecord{
    private String username;
    public UserRecord(String name){
        this.username = name;

    }

    public void setUsername(String name){
        this.username = name;
    }
    public void show(){
        System.out.println("User: "+username+" (ID: "+getId()+" )");

    }

    @Override
    public DatabaseRecord clone(){
        return new UserRecord(this.username);
    }
}
