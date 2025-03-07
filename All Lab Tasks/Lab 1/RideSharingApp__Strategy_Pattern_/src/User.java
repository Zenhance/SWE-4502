public abstract class User {
    public int id;
    public String name;
    public double rating;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 0; // Default rating for a new user
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public double getRating() {
        return rating;
    }

    public abstract void displayInfo();
}
