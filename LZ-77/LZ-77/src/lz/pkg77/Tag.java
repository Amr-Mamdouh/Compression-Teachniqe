package lz.pkg77;
import java.util.*;

public class Tag {
    private int pointer;
    private int length;
    private String nextChar;

    public Tag() {
        this.pointer = 0;
        this.length = 0;
        this.nextChar = " ";
    }

    public Tag(int pointer, int length, String nextChar) {
        this.pointer = pointer;
        this.length = length;
        this.nextChar = nextChar;
    }

    @Override
    public String toString() {
        return String.format("<%d,%d,%s>", pointer,length,nextChar);
    }
    
    
    
}
