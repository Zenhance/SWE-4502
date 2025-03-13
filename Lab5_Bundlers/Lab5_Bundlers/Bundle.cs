using System;
using System.Collections.Generic;

namespace Lab5_Bundlers
{
    // Composite - Bundle
    public abstract class Bundle : IProduct
    {
        private string _name;
        private decimal _discount; // Discount applied to the total bundle price
        protected List<IProduct> _products = new List<IProduct>();

        public Bundle(string name, decimal discount)
        {
            _name = name;
            _discount = discount;
        }

        public void AddProduct(IProduct product)
        {
            _products.Add(product);
        }

        public void RemoveProduct(IProduct product)
        {
            _products.Remove(product);
        }

        public string GetName()
        {
            return _name;
        }

        public decimal GetPrice()
        {
            decimal total = 0;
            foreach (var product in _products)
            {
                total += product.GetPrice();
            }
            // Apply discount to the total price of the bundle
            return total * (1 - _discount);
        }

        public void DisplayProductDetails()
        {
            Console.WriteLine($"Bundle: {_name}, Total Price after Discount: BDT {GetPrice():0.00}");
            Console.WriteLine("Contains:");
            foreach (var product in _products)
            {
                product.DisplayProductDetails();
            }
        }

        protected abstract List<IProduct> BuildBundle();
    }
}
