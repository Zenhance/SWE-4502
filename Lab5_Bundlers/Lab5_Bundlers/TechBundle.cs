using System;
using System.Collections.Generic;

namespace Lab5_Bundlers
{
    internal class TechBundle : Bundle
    {
        public TechBundle(string name, decimal discount) : base(name, discount)
        {
            // Build the bundle immediately upon creation
            _products = BuildBundle();
        }

        protected override List<IProduct> BuildBundle()
        {
            List<IProduct> bundle = new List<IProduct>();

            // Add various products to the bundle
            var smartphone = new Product("Smartphone", "Latest model with advanced features", 799.99M);
            var laptop = new Product("Laptop", "High-performance laptop for gaming", 1499.99M);
            var tablet = new Product("Tablet", "Portable tablet with 10-inch display", 499.99M);
            var headphones = new Product("Headphones", "Noise-cancelling wireless headphones", 199.99M);

            // Add products to the bundle
            bundle.Add(smartphone);
            bundle.Add(laptop);
            bundle.Add(tablet);
            bundle.Add(headphones);

            return bundle;
        }
    }
}
