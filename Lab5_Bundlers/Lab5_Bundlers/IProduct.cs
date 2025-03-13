using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab5_Bundlers
{
    public interface IProduct
    {
        string GetName();
        decimal GetPrice();
        void DisplayProductDetails();
    }
}
