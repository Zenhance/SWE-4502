package LightLevel;

import Core.Observer;

public class LightLevel implements Observer {

    private boolean lightOn;

    @Override
    public void update(String eventType, Object value) {
        if(eventType.equals("lightLevel")){
            if((int) value<=50){
                lightOn= true;
            }
            else{
                lightOn= false;
            }
        }
    }

    private boolean isLightOn(){
        return lightOn;
    }
}
