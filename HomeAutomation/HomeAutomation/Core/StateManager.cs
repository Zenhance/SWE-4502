using System;
using System.Collections.Generic;
using System.ComponentModel;

namespace HomeAutomation.Core
{
    public class StateManager
    {
        private readonly List<IComponent> _components = new List<IComponent>();
        public EnvironmentalState CurrentState { get; private set; } = new EnvironmentalState();

        public void RegisterComponent(IComponent component)
        {
            if (!_components.Contains(component))
            {
                _components.Add(component);
            }
        }


        public void UpdateState(Action<EnvironmentalState> updateAction)
        {
            updateAction(CurrentState);
            NotifyComponents();
        }

        private void NotifyComponents()
        {
            foreach (var component in _components)
            {
                component.OnStateChanged(CurrentState);
            }
        }
    }
}
