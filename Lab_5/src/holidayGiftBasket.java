import java.util.ArrayList;

public class holidayGiftBasket extends CompositProduct{
    public holidayGiftBasket(){
        build();
    }

    @Override
    public void build(){
        addProduct(new Laptop("HP ENVY X360", 1000));
        addProduct(new Laptop("Acer Aspire ES 15", 600));
        addProduct(new Mobile("iPhone 16 ProMax", 1200));
    }
}
