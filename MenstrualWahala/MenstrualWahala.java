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
}
