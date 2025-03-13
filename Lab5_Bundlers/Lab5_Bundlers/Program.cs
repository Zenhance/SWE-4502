using System;

namespace Lab5_Bundlers
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a tech bundle
            Bundle techBundle = new TechBundle("Tech Bundle", 0.10M); // 10% discount

            // Display details and prices in one call
            techBundle.DisplayProductDetails();

            // Final price of the tech bundle
            Console.WriteLine($"\nTotal Price of Tech Bundle: BDT {techBundle.GetPrice():0.00}");

            // Keep the console open
            Console.ReadLine();
        }
    }
}
