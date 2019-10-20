package app.sharma.com;

public class Leave {

    private String From_Date, From_Month, From_Year, requested;
    private String To_Date, To_Month, To_Year;

    public String getFrom_Date() {
        return From_Date;
    }

    public void setFrom_Date(String from_Date) {
        From_Date = from_Date;
    }

    public String getFrom_Month() {
        return From_Month;
    }

    public void setFrom_Month(String from_Month) {
        From_Month = from_Month;
    }

    public String getFrom_Year() {
        return From_Year;
    }

    public void setFrom_Year(String from_Year) {
        From_Year = from_Year;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public String getTo_Date() {
        return To_Date;
    }

    public void setTo_Date(String to_Date) {
        To_Date = to_Date;
    }

    public String getTo_Month() {
        return To_Month;
    }

    public void setTo_Month(String to_Month) {
        To_Month = to_Month;
    }

    public String getTo_Year() {
        return To_Year;
    }

    public void setTo_Year(String to_Year) {
        To_Year = to_Year;
    }

    public Leave(String from_Date, String from_Month, String from_Year, String requested, String to_Date, String to_Month, String to_Year) {
        From_Date = from_Date;
        From_Month = from_Month;
        From_Year = from_Year;
        this.requested = requested;
        To_Date = to_Date;
        To_Month = to_Month;
        To_Year = to_Year;
    }

    public Leave() {
    }
}
