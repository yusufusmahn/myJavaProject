package MenstrualWahalaTest;

import MenstrualWahalaClassAndApp.MenstrualWahala;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MenstrualWahalaTest {
    @Test
    public void testNextPeriodStartForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,29), menstrualWahala.getNextPeriodStart());


    }

    @Test
    public void testNextPeriodEndForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,8,02),menstrualWahala.getNextPeriodEnd());

    }




}
