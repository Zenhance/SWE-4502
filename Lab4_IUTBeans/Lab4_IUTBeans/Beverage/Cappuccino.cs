using Lab4_IUTBeans;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class Cappuccino : Beverage
    {
        public override string GetDescription()
        {
            return "Cappuccino";
        }

        public override double Cost()
        {
            return 350; 
        }
    }
}







