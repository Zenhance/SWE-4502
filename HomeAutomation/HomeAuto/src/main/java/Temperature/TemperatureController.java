package Temperature;

import Core.Observer;

public class TemperatureController implements Observer {
    private boolean heaterOn;
    @Override
    public void update(String eventType, Object value) {
        if(eventType.equals("temperature")){
            if((int)value<18){
                heaterOn= true;
            }
            else{
                heaterOn= false;
            }
        }
    }

    public boolean isHeaterOn(){
        return heaterOn;
    }
}
