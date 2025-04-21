package allDiaryTest;

import myDiary.Diaries;
import myDiary.Diary;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiariesTest {

    @Test
    public void testToAddDiary() {
        Diaries myDiaries = new Diaries();
        myDiaries.add("ama", "password");
        Diary myDiary =  myDiaries.findByUserName("ama");
        assertNotNull(myDiary);
        assertEquals(myDiary.getUsername(), "ama");

    }

    @Test
    public void testToAddDuplicateDiary() {
        Diaries myDiaries = new Diaries();
        myDiaries.add("ama", "password");
        myDiaries.add("ama", "password123");
        Diary myDiary1 =  myDiaries.findByUserName("ama");
        assertNotNull(myDiary1);
        myDiaries.add("ama", "password");
        Diary myDiary2 =  myDiaries.findByUserName("ama");
        assertNotNull(myDiary2);
        assertEquals(myDiary1, myDiary2);

    }

    @Test
    public void testToFindByUserName() {
        Diaries myDiaries = new Diaries();
        myDiaries.add("ama", "password");
        Diary myDiary = myDiaries.findByUserName("ama");
        assertNotNull(myDiaries);
        assertEquals(myDiary.getUsername(), "ama");
        assertNull(myDiaries.findByUserName("yusuf"));
    }


    @Test
    public void testToDeleteDiary() {
        Diaries myDiaries = new Diaries();
        myDiaries.add("ama", "password");
        myDiaries.delete("ama", "password");
        assertNull(myDiaries.findByUserName("ama"));

    }


    @Test
    public void testToDeleteDiaryWithIncorrectPassword() {
        Diaries myDiaries = new Diaries();
        myDiaries.add("ama", "password");
        myDiaries.delete("ama", "password123");
        assertNotNull(myDiaries.findByUserName("ama"));
    }

    @Test
    public void testToDeleteNonExistingDiary() {
        Diaries myDiaries = new Diaries();
        myDiaries.add("ama", "password");
        myDiaries.delete("me", "password");
        assertNull(myDiaries.findByUserName("me"));
        assertNotNull(myDiaries.findByUserName("ama"));
    }

}
