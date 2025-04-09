package MenstrualWahalaClassAndApp;
import java.time.LocalDate;

public class MenstrualWahala {
    private LocalDate lastPeriodDate;
    private int menstrualCycleLength;
    private int periodLength;

    public MenstrualWahala(LocalDate lastPeriodDate, int menstrualCycleLength, int periodLength) {
        this.lastPeriodDate = lastPeriodDate;
        this.menstrualCycleLength = menstrualCycleLength;
        this.periodLength = periodLength;
    }

    public LocalDate getNextPeriodStart() {
        return lastPeriodDate.plusDays(menstrualCycleLength);

    }

    public LocalDate getNextPeriodEnd() {
        return getNextPeriodStart().plusDays(periodLength - 1);
    }

    public LocalDate getOvulationPeriod() {
        return getNextPeriodStart().minusDays(14);
    }

    public LocalDate getFertilePeriodStart() {
        return getOvulationPeriod().minusDays(5);
    }

    public LocalDate getFertilePeriodEnd() {
        return getOvulationPeriod().plusDays(1);
    }

    public LocalDate getSafePeriod1Start() {
        return lastPeriodDate;
    }

    public LocalDate getSafePeriod1End() {
        return getFertilePeriodStart().minusDays(1);
    }

    public LocalDate getSafePeriod2Start() {
        return getFertilePeriodEnd().plusDays(1);
    }


    public LocalDate getSafePeriod2End() {
        return getNextPeriodStart().minusDays(1);
    }

    public LocalDate getFlowDateStart() {
        return getNextPeriodStart();
    }

    public LocalDate getFlowDateEnd() {
        return getNextPeriodEnd();
    }
}
