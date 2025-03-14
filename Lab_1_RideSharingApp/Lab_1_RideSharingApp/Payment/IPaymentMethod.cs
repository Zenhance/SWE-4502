using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public interface IPaymentMethod
    {
        void ProcessPayment(double amount); 
    }
}
