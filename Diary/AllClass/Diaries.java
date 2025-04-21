package myDiary;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries;

    public Diaries() {
        this.diaries = new ArrayList<>();
    }

    public void add(String username, String password) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                return;
            }
        }
        Diary newDiary = new Diary(username, password);
        diaries.add(newDiary);
    }

    public Diary findByUserName(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                return diary;
            }
        }
        return null;
    }

    public void delete(String username, String password) {
        Diary toRemove = null;
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                if (diary.isLocked()) {
                    diary.unlockDiary(password);
                    if (!diary.isLocked()) {
                        toRemove = diary;
                    }
                } else {
                    if (diary.verifyPassword(password)) {
                        toRemove = diary;
                    }
                }
                break;
            }
        }
        if (toRemove != null) {
            diaries.remove(toRemove);
        }
    }
}