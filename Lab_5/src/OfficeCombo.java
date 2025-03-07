import java.util.ArrayList;

public class OfficeCombo extends CompositProduct{
    public OfficeCombo(){
        build();
    }

    @Override
    public void build(){
        addProduct(new holidayGiftBasket());
        addProduct(new Laptop("Lenovo IdeaPad Gaming 3", 3000));
    }
}
