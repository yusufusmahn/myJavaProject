package allDiaryTest;

import myDiary.Diary;
import myDiary.Entry;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiaryTest {
    @Test
    public void testDiaryCreation() {
        Diary myDiary = new Diary("ama", "password");
        assertEquals("ama", myDiary.getUsername());
        assertFalse(myDiary.isLocked());
    }

    @Test
    public void testToCreateEntryWhenDiaryIsUnlocked() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.createEntry("first day", "sports day");
        Entry entry = myDiary.findEntryById(1);
        assertNotNull(entry);
        assertEquals("sports day", entry.getBody());
        assertEquals("first day", entry.getTitle());

    }


    @Test
    public void testToCreateEntryWhenDiaryLocked() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.lockDiary();
        myDiary.createEntry("first day", "sports day");
        assertNull(myDiary.findEntryById(1));
    }


    @Test
    public void testToUpdateEntryWhenDiaryUnlocked() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.createEntry("first day", "sports day");
        myDiary.updateEntry(1,"update first day", "update sports day");
        Entry entry = myDiary.findEntryById(1);
        assertNotNull(entry);
        assertEquals("update sports day", entry.getBody());
        assertEquals("update first day", entry.getTitle());
    }


    @Test
    public void testToUpdateEntryThatDoesNotExists() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.updateEntry(1, "No Entry", "Nothing oo");
        assertNull(myDiary.findEntryById(1));
    }

    @Test
    public void testToDeleteEntryWhenDiaryUnlocked() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.createEntry("first day", "sports day");
        myDiary.deleteEntry(1);
        assertNull(myDiary.findEntryById(1));
    }

    @Test
    public void testToDeleteEntryWhenDiaryLocked() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.createEntry("first day", "sports day");
        myDiary.lockDiary();
        myDiary.deleteEntry(1);
        myDiary.unlockDiary("password");
        Entry myEntry = myDiary.findEntryById(1);
        assertNotNull(myEntry);
        assertEquals("first day", myEntry.getTitle());
    }

    @Test
    public void testToLockDiary() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testToUnlockDiaryWithCorrectPassword() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.lockDiary();
        myDiary.unlockDiary("password");
        assertFalse(myDiary.isLocked());
    }


    @Test
    public void testToUnlockDiaryWithIncorrectPassword() {
        Diary myDiary = new Diary("ama", "password");
        myDiary.lockDiary();
        myDiary.unlockDiary("key");
        assertTrue(myDiary.isLocked());
    }
































}
