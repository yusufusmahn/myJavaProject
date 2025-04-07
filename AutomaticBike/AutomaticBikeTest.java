import AutomaticBike.AutomaticBike;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutomaticBikeTest {
    @Test
    public void testThatOnMethodWorksforAutomaticBike() {
        AutomaticBike myBike = new AutomaticBike();
        assertFalse(myBike.isItOn());
        myBike.SwitchOn();
        assertTrue(myBike.isItOn());

    }

    @Test
    public void testThatOffMethodWorksforAutomaticBike() {
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        assertTrue(myBike.isItOn());
        myBike.swuitchOff();
        assertFalse(myBike.isItOn());

    }

    @Test
    public void testThatGear1AccelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(15);
        assertEquals(1, myBike.getGear());
        myBike.accelerate();
        assertEquals(16, myBike.getSpeed());
    }

@Test
    public void testThatGear2AccelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(24);
        assertEquals(2, myBike.getGear());
        myBike.accelerate();
        assertEquals(26, myBike.getSpeed());

    }

    @Test
    public void testThatGear3AccelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(35);
        myBike.accelerate();
        assertEquals(38, myBike.getSpeed());

    }

    @Test
    public void testThatGear4AccelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(44);
        myBike.accelerate();
        assertEquals(48, myBike.getSpeed());
    }


    @Test
    public void testThatGear1DecelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(16);
        myBike.decelerate();
        assertEquals(15, myBike.getSpeed());
    }

    @Test
    public void testThatGear2DecelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(24);
        myBike.decelerate();
        assertEquals(22, myBike.getSpeed());
    }

    @Test
    public void testThatGear3DecelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(35);
        myBike.decelerate();
        assertEquals(32, myBike.getSpeed());
    }

    @Test
    public void testThatGear4DecelerationMethodWorks(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(41);
        myBike.decelerate();
        assertEquals(37, myBike.getSpeed());
    }


    @Test
    public void testThatGearShiftForwardFrom1To2Works(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(20);
        assertEquals(1, myBike.getGear());
        myBike.accelerate();
        assertEquals(21, myBike.getSpeed());
        assertEquals(2, myBike.getGear());

    }

    @Test
    public void testThatGearShiftBackwardFrom2To1Works(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(21);
        assertEquals(2, myBike.getGear());
        myBike.decelerate();
        assertEquals(19, myBike.getSpeed());
        assertEquals(1, myBike.getGear());

    }

    @Test
    public void testThatGearShiftfForwardFrom2To3Works(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(30);
        assertEquals(2, myBike.getGear());
        myBike.accelerate();
        assertEquals(32, myBike.getSpeed());
        assertEquals(3, myBike.getGear());
    }

    @Test
    public void testThatGearShiftBackwardFrom3To2Works(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(31);
        assertEquals(3, myBike.getGear());
        myBike.decelerate();
        assertEquals(2, myBike.getGear());
        assertEquals(28, myBike.getSpeed());
    }


    @Test
    public void testThatGearShiftForwardFrom3To4Works(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(40);
        assertEquals(3, myBike.getGear());
        myBike.accelerate();
        assertEquals(43, myBike.getSpeed());
        assertEquals(4, myBike.getGear());
    }


    @Test
    public void testThatGearShiftBackwardFrom4To3Works(){
        AutomaticBike myBike = new AutomaticBike();
        myBike.SwitchOn();
        myBike.setSpeed(41);
        assertEquals(4, myBike.getGear());
        myBike.decelerate();
        assertEquals(37, myBike.getSpeed());
        assertEquals(3, myBike.getGear());
    }



}
