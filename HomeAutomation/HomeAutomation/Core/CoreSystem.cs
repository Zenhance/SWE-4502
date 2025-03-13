using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    public class CoreSystem
    {
        private List<IComponent> components = new List<IComponent>();

        public void RegisterComponent(IComponent component)
        {
            components.Add(component);
        }

        public bool HasComponent(IComponent component)
        {
            return components.Contains(component);
        }

        public void NotifyComponents(string property, object value)
        {
            foreach (var component in components)
            {
                component.Update(property, value);
            }
        }
    }
}
