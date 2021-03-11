package common;

public class FixedInt {


    public char[] encode(int value) {

        char[] ch = new char[4];
        ch[0] = (char) (value & 0xffff);
        ch[1] = (char) (value >>> 16 & 0xffff);

        return ch;
    }
}
