package lt.techin.oop;

public final class SimpleDate {
 private final int day,month,year;
 public SimpleDate(int day,int month,int year){this.day=day;this.month=month;this.year=year;}
 public int getDay(){return day;} public int getMonth(){return month;} public int getYear(){return year;}
 @Override public boolean equals(Object other){if(this==other)return true;if(!(other instanceof SimpleDate d))return false;return day==d.day&&month==d.month&&year==d.year;}
 @Override public int hashCode(){return java.util.Objects.hash(day,month,year);}
 @Override public String toString(){return day+"."+month+"."+year;}
}
