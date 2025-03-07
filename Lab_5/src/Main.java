public class Main {
    public static void main(String[] args) {
        Iproduct pd = new OfficeCombo();
        pd.printDetails();
        System.out.println("\n\nTotal price : " + pd.getPrice());
    }
}