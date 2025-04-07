package MyAC;

public class MyAC {
    private boolean isOn;
    private int temperature;

    public MyAC() {
        this.isOn = false;
        this.temperature = 16;
    }

    public void OnAirConditioner() {
        this.isOn = true;

    }


    public boolean isOn() {
        return this.isOn;
    }

    public void OffAirConditioner() {
        this.isOn = false;
    }

    public void increaseTemperature() {
        if(this.isOn && this.temperature < 30) {
            this.temperature += 1;
        }
    }

    public int getInitialTemperature() {
        return this.temperature;
    }


    public int decreaseTemperature() {
        if(this.isOn && this.temperature > 16) {
            return this.temperature -= 1;
        }
        return 0;
    }


    public void setInitialTemperature(int temperature) {
        this.temperature = temperature;
    }
}
