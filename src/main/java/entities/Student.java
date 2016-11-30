package entities;

/**
 * Created by imac on 29.11.16.
 */
public class Student {

    private String name;
    private String gender;
    private String groupNumber;
    private int id;
    private int visits;

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String toString() {
        return new StringBuilder()
                .append(name)
                .append(" ")
                .append(gender)
                .append(" ")
                .append(groupNumber)
                .append(" ")
                .append(visits)
                .toString();
    }
}