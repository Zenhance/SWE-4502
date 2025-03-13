using HomeAutomate.Enum;

namespace HomeAutomate.Factory;

public class LightModeFactory
{
    public static LIGHTMODE getMode(float ambience)
    {
        if (ambience < 0.1)
        {
            return LIGHTMODE.NIGHT;
        }
        else if (ambience < 0.3)
        {
            return LIGHTMODE.MOVIE;
        }
        else if (ambience < 0.5)
        {
            return LIGHTMODE.READING;
        }
        else if (ambience < 0.7)
        {
            return LIGHTMODE.PARTY;
        }
        else
        {
            return LIGHTMODE.DAYLIGHT;
        }
    }

    public static float getLevel(float motionLevel)
    {
        if(motionLevel < 0.1)
        {
            return 0.0f;
        }
        else if(motionLevel < 0.3)
        {
            return 0.3f;
        }
        else if(motionLevel < 0.5)
        {
            return 0.5f;
        }
        else if(motionLevel < 0.7)
        {
            return 0.7f;
        }
        else
        {
            return 1.0f;
        }
    }
}