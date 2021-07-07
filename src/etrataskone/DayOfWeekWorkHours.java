package etrataskone;

public enum DayOfWeekWorkHours {

    SUNDAY("Выходной"),
    MONDAY("40 часов до конца рабочей недели"),
    TUESDAY("32 часа до конца рабочей недели"),
    WEDNESDAY("24 часа до конца рабочей недели"),
    THURSDAY("16 часов до конца рабочей недели"),
    FRIDAY("8 часов до конца рабочей недели"),
    SATURDAY("Выходной");

    private String hours;

    DayOfWeekWorkHours(String string) {
        this.hours = string;
    }

    @Override
    public String toString() {
        return hours;
    }
}
