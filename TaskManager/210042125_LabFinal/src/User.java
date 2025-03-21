public class User implements Subscribe{
    private String name;
    Issue i;
    public User(Issue i, String name){
        this.i= i;
        this.name= name;
    }

    public String getName(){
        return name;
    }
    public void subscribe(){
        i.AddSubscriber(this);
    }

    @Override
    public void update(String s) {
        System.out.println(name+ " got the update: "+s);
    }


}
