package entities;

/**
 * Created by imac on 29.11.16.
 */
public class Lecture {
    private int id;
    private String date;
    private String topic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String toString() {
        return new StringBuilder()
                .append(topic)
                .append(" ")
                .append(date)
                .toString();
    }
}