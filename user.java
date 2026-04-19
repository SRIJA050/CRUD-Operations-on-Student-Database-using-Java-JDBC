package nodejs;

public class User {
    private String name;
    private String rollnumber;
    private String branch;
    private int marks;

    public User(String name, String rollnumber, String branch, int marks) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.branch = branch;
        this.marks = marks;
    }

    public String getName() { return name; }
    public String getRollnumber() { return rollnumber; }
    public String getBranch() { return branch; }
    public int getMarks() { return marks; }
}
