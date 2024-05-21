package eapli.ecourse.postit.domain;


import eapli.ecourse.student.domain.Student;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostItTest {

    private PostIt postIt1;
    private Student student1;
    private Student student2;
    private Content content1;
    private Content content2;

    @Before
    public void setUp() {
        student1 = mock(Student.class);
        when(student1.identity()).thenReturn(EmailAddress.valueOf("email100@email.org"));
        student2 = mock(Student.class);
        when(student2.identity()).thenReturn(EmailAddress.valueOf("email200@email.org"));
        content1 = new Content(ContentType.TEXT, "content".getBytes());
        content2 = new Content(ContentType.TEXT, "content2".getBytes());
        postIt1 = new PostIt(content1, student1);
    }

    @Test
    public void changePostIt() {
        assertEquals(content1, postIt1.content());
        postIt1.changePostIt(content2);
        assertEquals(content2, postIt1.content());
    }

    @Test
    public void isOwner() {
        assertFalse(postIt1.isOwner(student2.identity()));
        assertTrue(postIt1.isOwner(student1.identity()));
    }
    @Test
    public void equalsTest(){
        PostIt postIt2 = new PostIt(content1, student1);
        PostIt postIt3 = new PostIt(content1, student1);
        PostIt postIt4 = new PostIt(content2, student1);
        assertEquals(postIt2, postIt2);
        assertEquals(postIt2, postIt3);
        assertNotEquals(postIt2, postIt4);
        assertNotEquals(postIt2, null);
        assertNotEquals(postIt2, new Object());
    }
    @Test
    public void ensurePostItIsNotCreatedWithNullContent() {
        assertThrows(IllegalArgumentException.class, () -> new PostIt(null, student1));
    }

    @Test
    public void ensurePostItIsNotCreatedWithNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> new PostIt(content1, null));
    }

    @Test
    public void ensurePostItIsCreatedWithValidData() {
        PostIt postIt2 = new PostIt(content1, student1);
        assertNotNull(postIt2);
    }


}