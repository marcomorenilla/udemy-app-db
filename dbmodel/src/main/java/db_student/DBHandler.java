package db_student;

public enum DBHandler {

    INSTANCE;
    private DB db;

    private DBHandler(){
        db = new DB();
    }
    public DB getInstance(){
        return db;
    }
}
