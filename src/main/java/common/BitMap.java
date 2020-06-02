package common;

public class BitMap {
    private static final byte mask = 3;
    private static final int maxNum = (1 << mask) -1; // 111
    private int size;
    private byte[] elementData;

    BitMap() {
        elementData = new byte[1 << (Integer.SIZE - mask)];
    }

}
