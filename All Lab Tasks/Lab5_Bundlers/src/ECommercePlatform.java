public class ECommercePlatform {
    public static void main(String[] args) {

        TechBundle techBundle = new TechBundle();

        AccessoriesBundle accessoriesBundle = new AccessoriesBundle();


        System.out.println("Tech Bundle Details:");
        techBundle.displayProductInfo();

        System.out.println("\nAccessories Bundle Details:");
        accessoriesBundle.displayProductInfo();
    }
}
