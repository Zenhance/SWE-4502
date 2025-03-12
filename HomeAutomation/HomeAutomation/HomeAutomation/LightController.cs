using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
  
    public class LightController : IStateChangeListener
    {
        private ILightStrategy _lightStrategy;

        public LightController(ILightStrategy lightStrategy)
        {
            _lightStrategy = lightStrategy;
            StateChangeNotifier.Instance.Subscribe(this);
        }

        public void SetLightStrategy(ILightStrategy lightStrategy)
        {
            _lightStrategy = lightStrategy;
        }

        public void AdjustLighting(int ambientLightLevel, bool isOccupied)
        {
            _lightStrategy.AdjustLighting(ambientLightLevel, isOccupied);
        }

        public void OnStateChange(EnvironmentState state)
        {
            
        }
    }
}
