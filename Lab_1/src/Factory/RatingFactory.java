package Factory;

import java.util.Scanner;

public class RatingFactory {
    Scanner scanner = new Scanner(System.in);
    public static double createDriverRating(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rate the driver from 1 to 5: ");
        double rating = scanner.nextDouble();
        if(rating < 1 || rating > 5){
            System.out.println("Invalid Rating");
            rating = createDriverRating();
        }
        return rating;
    }

    public static double createRiderRating(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rate the rider from 1 to 5: ");
        double rating = scanner.nextDouble();
        if(rating < 1 || rating > 5){
            System.out.println("Invalid Rating");
            rating = createRiderRating();
        }
        return rating;
    }
}
