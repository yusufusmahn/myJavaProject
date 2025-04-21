package myDiary;

import java.time.LocalDateTime;

public class Entry {
    private final int id;
    private String title;
    private String body;
    private final LocalDateTime dateCreated;

    public Entry(int id, String title, String body, LocalDateTime dateAndTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = dateAndTime;

    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setBody(String newBody) {
        this.body = newBody;
    }
}
