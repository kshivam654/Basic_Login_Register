package app.sharma.com;

public class Request {
    private int date, month, year, requested;

    public Request(int date, int month, int year, int requested) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.requested = requested;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRequested() {
        return requested;
    }

    public void setRequested(int requested) {
        this.requested = requested;
    }

    public Request() {
    }
}
