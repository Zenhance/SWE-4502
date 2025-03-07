import java.util.ArrayList;

public class TheStudentCombo extends CompositProduct{
    public TheStudentCombo(){
        build();
    }

    @Override
    public void build(){
        addProduct(new Laptop("Asus VIVObook", 450));
        addProduct(new Mobile("Samsung Galaxy A52", 200));
    }
}
