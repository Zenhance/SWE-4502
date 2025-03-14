using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class CondimentDecorator : Beverage
    {
        private Beverage beverage; 
        private ICondiment condiment; 

        public CondimentDecorator(Beverage beverage, ICondiment condiment)
        {
            this.beverage = beverage; 
            this.condiment = condiment; 
        }

        public override string GetDescription()
        {
            return beverage.GetDescription() + ", " + condiment.GetCondimentDescription(); // Concatenating descriptions
        }

        public override double Cost()
        {
            return beverage.Cost() + condiment.GetCondimentCost(); // Calculating total cost
        }
    }



}
