using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    /// <summary>
    /// Manages environmental state and notifies registered components of changes.
    /// </summary>
    public class StateManager
    {
        private Dictionary<string, object> _state;
        private Dictionary<string, List<Action<object>>> _subscribers;

        public StateManager()
        {
            _state = new Dictionary<string, object>();
            _subscribers = new Dictionary<string, List<Action<object>>>();
        }

        /// <summary>
        /// Updates the state and notifies all subscribed components.
        /// </summary>
        /// <param name="key">The state key (e.g., "temperature", "lightLevel").</param>
        /// <param name="value">The new value for the state.</param>
        public void UpdateState(string key, object value)
        {
            _state[key] = value;
            NotifySubscribers(key, value);
        }

        /// <summary>
        /// Retrieves the current state value for a given key.
        /// </summary>
        /// <param name="key">The state key.</param>
        /// <returns>The state value.</returns>
        public object GetState(string key)
        {
            return _state.ContainsKey(key) ? _state[key] : null;
        }

        /// <summary>
        /// Allows a component to subscribe to state changes for a specific key.
        /// </summary>
        /// <param name="key">The state key to observe.</param>
        /// <param name="callback">The callback function to execute on state change.</param>
        public void Subscribe(string key, Action<object> callback)
        {
            if (!_subscribers.ContainsKey(key))
            {
                _subscribers[key] = new List<Action<object>>();
            }
            _subscribers[key].Add(callback);
        }

        /// <summary>
        /// Notifies all subscribers of a state change.
        /// </summary>
        /// <param name="key">The state key that changed.</param>
        /// <param name="value">The new value of the state.</param>
        private void NotifySubscribers(string key, object value)
        {
            if (_subscribers.ContainsKey(key))
            {
                foreach (var callback in _subscribers[key])
                {
                    callback(value);
                }
            }
        }
    }
}
