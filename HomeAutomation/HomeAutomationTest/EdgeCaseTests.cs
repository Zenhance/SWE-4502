using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTest
{
    public class EdgeCaseTests
    {
        [Fact]
        public void UpdateState_WithNoRegisteredComponents_DoesNotThrow()
        {
          
            var stateManager = new StateManager();

           
            var exception = Record.Exception(() =>
                stateManager.UpdateState(state =>
                {
                    state.Temperature = -10;  
                    state.AmbientLight = -5;   
                })
            );
            Assert.Null(exception);
        }
    }
    }
