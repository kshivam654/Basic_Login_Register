package app.sharma.com;

public class User {

    private String name, email, year, branch, group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public User(String name, String email, String year, String branch, String group) {
        this.name = name;
        this.email = email;
        this.year = year;
        this.branch = branch;
        this.group = group;
    }

    public User() {
    }
}
