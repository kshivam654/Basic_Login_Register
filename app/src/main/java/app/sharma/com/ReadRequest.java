package app.sharma.com;

public class ReadRequest {
    private Leave leave;
    private User user;

    public ReadRequest(Leave leave, User user) {
        this.leave = leave;
        this.user = user;
    }

    public ReadRequest() {
    }

    public Leave getLeave() {
        return leave;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
