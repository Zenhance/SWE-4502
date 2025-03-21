public class User implements Subscribe{
    private String name;
    Issue i;

    public User(Issue i){
        this.i= i;
    }

    public void subscribe(){
        i.AddSubscriber(this);
    }

    @Override
    public void update(String s) {
        System.out.println(name+ " got the update: "+s);
    }


}
