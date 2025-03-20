package src.prototypecase;

public abstract class DatabaseRecord implements Cloneable{
    private int id;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public abstract DatabaseRecord clone();
}
