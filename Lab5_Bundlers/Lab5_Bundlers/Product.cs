using System;

namespace Lab5_Bundlers
{
    // Leaf - Simple Product
    public class Product : IProduct
    {
        private string _name;
        private string _description;
        private decimal _price;

        public Product(string name, string description, decimal price)
        {
            _name = name;
            _description = description;
            _price = price;
        }

        public string GetName()
        {
            return _name;
        }

        public decimal GetPrice()
        {
            return _price;
        }

        public void DisplayProductDetails()
        {
            Console.WriteLine($"Product: {_name}, Description: {_description}, Price: BDT {_price:0.00}");
        }
    }
}
