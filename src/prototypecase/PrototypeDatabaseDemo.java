package src.prototypecase;

class PrototypeDatabaseDemo {
    public static void main(String[] args) {
        DatabaseCache.loadCache();

        UserRecord clonedUser = (UserRecord) DatabaseCache.getRecord(1);
        clonedUser.show(); // Output: User: JohnDoe (ID: 1)
    }
}
