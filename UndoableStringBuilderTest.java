import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit test class for UndoableStringBuilder
 * Main purpose is to check undo function after each possible change
 * Not checking StringBuilder original functions
 * @author Nikita Breslavsky,Hen Dahan
 * 4.11.2022
 */
class UndoableStringBuilderTest {




    UndoableStringBuilder usb = new UndoableStringBuilder();

    @BeforeEach
    void setUp() {
        usb.append("hello");
    }

    @Test
    void undoWhenStackIsEmpty(){
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.undo();
        usb.undo();
        assertEquals("",usb.toString());
        usb.append("123");
        usb.undo();
        usb.undo();
        assertEquals("",usb.toString());

    }
    @Test
    void undoCheck(){
        usb.append("world!");
        usb.undo();
        assertEquals("hello", usb.toString());
        usb.undo();
        assertEquals("", usb.toString());
    }
    @Test
    void appendCheck(){
        assertEquals("hello",usb.toString());
        usb.append(" world");
        assertEquals("hello world",usb.toString());
        usb.append("!");
        assertNotEquals("hello world", usb.toString());
        usb.undo();
        assertEquals("hello world",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }
    @Test
    void deleteCheck(){
        usb.delete(0,3);
        assertNotEquals("hello",usb.toString());
        assertEquals("lo",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }
    @Test
    void insertCheck(){
        usb.insert(3," ");
        assertNotEquals("hello",usb.toString());
        assertEquals("hel lo",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }


    @Test
    void replaceCheck(){
        usb.replace(0,5,"bye");
        assertNotEquals("hello",usb.toString());
        assertEquals("bye",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }

    @Test
    void reverseCheck(){
        usb.reverse();
        assertNotEquals("hello",usb.toString());
        assertEquals("olleh",usb.toString());
        usb.undo();
        assertEquals("hello",usb.toString());
    }

}