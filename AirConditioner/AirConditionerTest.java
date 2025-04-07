import MyAC.MyAC;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirConditionerTest {

    @Test
    public void testThatOnMethodWorksforAirConditioner() {
        MyAC myac = new MyAC();
        assertFalse(myac.isOn());
        myac.OnAirConditioner();
        assertTrue(myac.isOn());


    }


    @Test
    public void testThatOffMethodWorksForAirConditioner() {
        MyAC myac = new MyAC();
        myac.OnAirConditioner();
        assertTrue(myac.isOn());
        myac.OffAirConditioner();
        assertFalse(myac.isOn());

    }

    @Test
    public void testThatIncreaseTemperatureMethodWorksForAirConditioner() {
        MyAC myac = new MyAC();
        myac.OnAirConditioner();
        myac.setInitialTemperature(17);
        myac.increaseTemperature();
        assertEquals(18, myac.getInitialTemperature());


    }


    @Test
    public void testThatDecreaseTemperatureMethodWorksForAirConditioner() {
        MyAC myac = new MyAC();
        myac.OnAirConditioner();
        myac.setInitialTemperature(21);
        myac.decreaseTemperature();
        assertEquals(20, myac.getInitialTemperature());


    }

    @Test
    public void testToIncreaseTemperaturebeyond30_MethodWorksForAirConditioner() {
        MyAC myac = new MyAC();
        myac.OnAirConditioner();
        myac.setInitialTemperature(30);
        myac.increaseTemperature();
        assertEquals(30, myac.getInitialTemperature());

    }

    @Test
    public void testToDecreaseTemperaturebelow16_MethodWorksForAirConditioner() {
        MyAC myac = new MyAC();
        myac.OnAirConditioner();
        myac.setInitialTemperature(16);
        myac.decreaseTemperature();
        assertEquals(16, myac.getInitialTemperature());
    }


}
