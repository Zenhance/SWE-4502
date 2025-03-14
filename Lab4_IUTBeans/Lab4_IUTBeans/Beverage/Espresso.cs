using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    public class Espresso : Beverage
    {
        public override string GetDescription()
        {
            return "Espresso";
        }

        public override double Cost()
        {
            return 200; 
        }
    }
}
