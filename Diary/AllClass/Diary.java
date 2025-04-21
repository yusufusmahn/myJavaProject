package myDiary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked;
    private List<Entry> entries;


    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = false;
        this.entries = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }


    public boolean isLocked() {
        return isLocked;
    }


    public void createEntry(String title, String body) {
        if(isLocked) {
            return;
        }
        int id = entries.size() + 1;
        Entry entry = new Entry(id, title, body, LocalDateTime.now());
        entries.add(entry);
    }


    public Entry getLatestEntryId(){
        if(entries.isEmpty()){
            return null;
        }
        return entries.get(entries.size() - 1);

    }


    public Entry findEntryById(int id) {
        if(isLocked()){
            return null;
        }
        for (Entry entry : entries) {
            if(entry.getId() == id){
                return entry;
            }
        }
        return null;
    }


    public void lockDiary() {
        if(isLocked()) {
            return;
        }
        isLocked = true;
    }


    public void updateEntry(int id, String newTitle, String newBody) {
        if(isLocked()) {
            return;
        }
        Entry entry = findEntryById(id);
        if(entry == null) {
            return;
        }
        entry.setTitle(newTitle);
        entry.setBody(newBody);
    }


    public void deleteEntry(int id) {
        if (isLocked()) {
            return;
        }
        Entry entry = findEntryById(id);
        if (entry == null) {
            return;
        }
        entries.remove(entry);
    }


    public void unlockDiary(String password) {
        if(!isLocked()) {
            return;
        }
        if(this.password.equals(password)) {
            isLocked = false;
        }

    }


    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

}
