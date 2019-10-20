package app.sharma.com;

public class Request {
    private String date, month, year, requested;

    public Request() {
    }

    public Request(String date, String month, String year, String requested) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.requested = requested;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }
}
