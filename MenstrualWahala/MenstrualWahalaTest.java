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



    @Test
    public void testOvulationPeriodForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,19),menstrualWahala.getOvulationPeriod());

    }

    @Test
    public void testFertilePeriodStartForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,14),menstrualWahala.getFertilePeriodStart());

    }

    @Test
    public void testFertilePeriodEndForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,20),menstrualWahala.getFertilePeriodEnd());

    }

    @Test
    public void testSafePeriod1StartForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,1),menstrualWahala.getSafePeriod1Start());

    }

    @Test
    public void testSafePeriod1EndForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,13),menstrualWahala.getSafePeriod1End());

    }

    @Test
    public void testSafePeriod2StartForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,21),menstrualWahala.getSafePeriod2Start());

    }

    @Test
    public void testSafePeriod2EndForMenstrualCycleWahala() {
        MenstrualWahala menstrualWahala = new MenstrualWahala(LocalDate.of(2025,7,1),28,5);
        assertEquals(LocalDate.of(2025,7,28),menstrualWahala.getSafePeriod2End());

    }






}
