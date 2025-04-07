package AutomaticBike;

public class AutomaticBike {
    private boolean isItOn;
    private int speed;
    private int gear;

    public AutomaticBike() {
        this.isItOn = false;
        this.speed = 0;
        this.gear = 1;
    }

    public void SwitchOn() {
        this.isItOn = true;
    }

    public boolean isItOn() {
        return this.isItOn;
    }

    public void swuitchOff() {
        this.isItOn = false;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        this.gearControl();

    }

    public int getSpeed() {
        return this.speed;
    }


    public void accelerate() {
        if (isItOn) {
            if (this.gear == 1) {
                this.speed += 1;
            } else if (this.gear == 2) {
                this.speed += 2;
            } else if (this.gear == 3) {
                this.speed += 3;
            } else {
                this.speed += 4;
            }

            this.gearControl();
        }

    }


    public int getGear() {
        return this.gear;
    }

    public void gearControl() {
        if(this.speed <= 20){
            this.gear = 1;
        }else if(this.speed <= 30){
            this.gear = 2;
        }else if(this.speed <= 40){
            this.gear = 3;
        }else {
            this.gear = 4;
        }

    }

    public void decelerate() {
        if (this.isItOn &&  this.speed > 0) {
            switch (this.gear) {
                case 1:
                    this.speed -= 1;
                    break;
                case 2:
                    this.speed -= 2;
                    break;
                case 3:
                    this.speed -= 3;
                    break;
                case 4:
                    this.speed -= 4;
                    break;
            }
            if(this.speed < 0){
                this.speed = 0;
            }
            this.gearControl();

        }
    }
}
