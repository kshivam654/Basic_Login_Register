package app.sharma.com;

public class Leave {

    private Request To, From;
    private String request;

    public Leave(Request to, Request from, String request) {
        To = to;
        From = from;
        this.request = request;
    }

    public Leave() {
    }

    public Request getTo() {
        return To;
    }

    public void setTo(Request to) {
        To = to;
    }

    public Request getFrom() {
        return From;
    }

    public void setFrom(Request from) {
        From = from;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
