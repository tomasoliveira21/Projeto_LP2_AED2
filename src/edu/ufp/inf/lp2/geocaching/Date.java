package edu.ufp.inf.lp2.geocaching;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {

    public int day;

    public int month;

    public int year;


    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
        GregorianCalendar c = new GregorianCalendar();
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.month = c.get(Calendar.MONTH) + 1;
        this.year = c.get(Calendar.YEAR);
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) return;//caso seja erro
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) return;
        {//caso seja erro
            this.month = month;
        }


    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2021) return;
        this.year = year;
    }

    public boolean beforeDate(Date d) {
      /*if(this.year == d.year){
          if(this.month== d.month){
              if(this.day == d.day){

              }else{
                  if(this.day > d.day){
                      return false;
                  }
                  else {
                      return true;
                  }
              }
          }else{
              if(this.month > d.month){
                  return false;
              }
              else {
                  return true;
              }
          }
      }else{
          if(this.month > d.month){
              return false;
          }
          else {
              return true;
          }
      }

        return false;
        */
        return this.compareTo(d) < 0;
    }

    public boolean afterDate(Date d) {
       /* if(this.compareTo(d)>0){
            return true;
        }else
            return false;
       */
        //return !this.beforeDate(d);

        return this.compareTo(d) > 0;


    }

    public boolean isLeapYear(int year) {
        /*if(this.year%4==0){
            if (this.year%100!=0){
                return true;
            }else{
                if(this.year%400==0){
                    return true;
                }else return false;
            }
        }
        return false;
        */
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    @Override
    public String toString() {
        return "Date{" +
                "Day=" + day +
                ", Month=" + month +
                ", Year=" + year +
                '}';
    }
    public String print() {
        return  "(" + day + "," + month + "," + year + ")";
    }

    public void incrementDate() {
        if (this.day < daysMonth(this.month, this.year)) {
            day++;
        } else {
            if (this.month == 12) {
                this.day = 1;
                this.month = 1;
                this.year++;

            } else {
                month++;
                day = 1;
            }
        }
    }

    public int differenceYears(Date d) {
        if(this.year == d.year){
            return differenceMonths(this,d);
        }
        int ndias = differenceMonths(this,new Date(31,12,this.year));
        while(this.year <d.year){
            if(isLeapYear(this.year)){
                ndias+=366;
            }else{
                ndias+=365;
            }
            this.year+=1;

        }
        ndias+=differenceMonths(new Date(1,1,this.year),d);
        return ndias;
    }

    private static int daysCrawlerAux(Date b, Date e) {
        if (b.equals(e)) {
            return 0;
        }
        b.incrementDate();
        return 1 + daysCrawlerAux(b, e);
    }

    private static long daysCrawlerRecursive(Date b, Date e) {
        if (e.year - b.year < 10) {
            return daysCrawlerAux(b, e);
        }
        int daysCount = 0;
        while (e.year - b.year > 10) {
            Date b2 = new Date(b);
            b.year = b.year + 10;
            daysCount += daysCrawlerAux(b ,b2);
        }
        daysCount+= daysCrawlerAux(b,e);
        return daysCount;
    }

    private static int differenceMonths(Date begin, Date end) {
        if (begin.month == end.month) {
            return end.day - begin.day;
        }
        int ndias = begin.daysMonth(begin.month, begin.year);//retorna numero de dias daquele mes
        int dayCounter = ndias - begin.day;//numero de dias inicial
        begin.setMonth(begin.month + 1);
        begin.setDay(1);
        while (begin.month < end.month) {
            dayCounter = begin.daysMonth(begin.month, begin.year);
            begin.setMonth(begin.month + 1);
        }
        dayCounter += end.day;
        return dayCounter;
    }

    public int compareTo(Date d) {
        if (this.year == d.year && this.month == d.month && this.day == d.day) {
            return 0;
        } else if (this.year == d.year) {
            if (this.month == d.month) {
                return (this.day - d.day) / Math.abs(this.day - d.day);
            } else {
                return (this.month - d.month) / Math.abs(this.month - d.month);
            }
        } else {
            return (this.year - d.year) / Math.abs(this.year - d.year);
        }

        /*OU
        if (this.year > d.year)return 1;
        if (this.year < d.year)return -1;
        if (this.year == d.year && this.month > d.month)return 1;
        if (this.year == d.year && this.month < d.month)return -1;
        if (this.year == d.year&& this.month == d.month && this.day > d.day)return 1;
        if (this.year == d.year && this.month == d.month && this.day < d.day)return -1;
        else return 0;
        */

    }

    public int daysMonth(int m, int y) {
        switch (m) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (this.isLeapYear(y)) {
                    return 29;
                } else return 28;
            default:
                return 31;
        }
    }

}