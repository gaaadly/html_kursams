package lt.techin.oop;

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day; this.month = month; this.year = year;
    }

    @Override public String toString() { return day + "." + month + "." + year; }

    public boolean before(SimpleDate compared) {
        if (year != compared.year) return year < compared.year;
        if (month != compared.month) return month < compared.month;
        return day < compared.day;
    }

    public void advance() {
        // TODO: move this object forward one day.
        day++;
        if (day > 30) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public void advance(int howManyDays) {
        // TODO: use advance() to move this object forward.
        for (int i = 0; i < howManyDays; i++) {
            advance();
        }
    }

    public SimpleDate afterNumberOfDays(int days) {
        // TODO: return a new date; leave this object unchanged.
        SimpleDate newDate = new SimpleDate(day, month, year);
        newDate.advance(days);
        return newDate;
    }
}
