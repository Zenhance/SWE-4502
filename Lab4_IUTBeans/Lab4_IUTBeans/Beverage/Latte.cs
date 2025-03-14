using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class Latte : Beverage
    {
        public override string GetDescription()
        {
            return "Latte";
        }

        public override double Cost()
        {
            return 300; 
        }
    }
}
