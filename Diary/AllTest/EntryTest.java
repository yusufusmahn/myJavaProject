package allDiaryTest;

import myDiary.Entry;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class EntryTest {
    @Test
    public void testEntryCreation() {
        LocalDateTime dateCreated = LocalDateTime.of(2025, 4, 18, 4, 0);
        Entry myEntry = new Entry(1, "title", "body", dateCreated);
        assertEquals(1, myEntry.getId());
        assertEquals("body", myEntry.getBody());
        assertEquals("title", myEntry.getTitle());
        assertEquals(dateCreated, myEntry.getDateCreated());

    }

    @Test
    public void testToSetTitle() {
        LocalDateTime dateCreated = LocalDateTime.of(2025, 4, 18, 4, 0);
        Entry myEntry = new Entry(1, "title", "body", dateCreated);
        myEntry.setTitle("new title");
        assertEquals("new title", myEntry.getTitle());
    }

    @Test
    public void testToSetBody() {
        LocalDateTime dateCreated = LocalDateTime.of(2025, 4, 18, 4, 0);
        Entry myEntry = new Entry(1, "title", "body", dateCreated);
        myEntry.setBody("new body");
        assertEquals("new body", myEntry.getBody());
    }


    @Test
    public void testThatIDShouldNeverChange() {
        LocalDateTime dateCreated = LocalDateTime.of(2025, 4, 18, 4, 0);
        Entry myEntry1 = new Entry(1, "title", "body", dateCreated);
        Entry myEntry2 = new Entry(2, " another title", "another body", dateCreated);
        assertNotEquals(myEntry1.getId(), myEntry2.getId());
    }

    @Test
    public void testThatDateCreatedShouldNeverChange() {
        LocalDateTime dateCreated1 = LocalDateTime.of(2025, 4, 18, 4, 0);
        LocalDateTime dateCreated2 = LocalDateTime.of(2025, 4, 19, 12, 0);
        Entry myEntry1 = new Entry(1, "title", "body", dateCreated1);
        Entry myEntry2 = new Entry(2, " another title", "another body", dateCreated2);
        assertNotEquals(myEntry1.getDateCreated(), myEntry2.getDateCreated());
    }







}
