package network;

public class BruceForceCoding {

    private static byte byteVal = 101;

    private static short shortVal = 10001;

    private static int intVal = 100000001;

    private static long longVal = 1000000000001L;

    private final static int BSIZE = Byte.SIZE;

    private final static int SSIZE = Short.SIZE;

    private final static int ISIZE = Integer.SIZE;

    private final static int LSIZE = Long.SIZE;

    private final static int BYTEMASK = 0xFF;

    public static String byteArrayToDecimalString(byte[] bArray) {
        StringBuilder rtn = new StringBuilder();

        for (byte b : bArray) {
            rtn.append(b & BYTEMASK).append(" ");
        }
        return rtn.toString();
    }

    public static int encodeIntBigEndian(byte[] dst, long val, int offset, int size) {
        for (int i = 0; i < size; i++) {
            dst[offset++] = (byte)(val >> ((size - i - 1) * BSIZE));
        }
        return offset;
    }

    public static long decodeIntBigEndian(byte[] val, int offset, int size) {
        long rtn = 0;
        for (int i = 0; i < size; i++) {
            rtn = (rtn << BSIZE | ((long) val[offset + 1]) & BYTEMASK);
        }
        return rtn;
    }

    public static void main(String[] args){
        byte[] message = new byte[BSIZE + SSIZE + ISIZE + LSIZE];

        // Encode the fields in the target byte array
        int offset = encodeIntBigEndian(message, byteVal, 0, BSIZE);
        offset = encodeIntBigEndian(message, shortVal, offset, SSIZE);
        offset = encodeIntBigEndian(message, intVal, offset, ISIZE);
        offset = encodeIntBigEndian(message, longVal, offset, LSIZE);

        System.out.println("Encoding message: " + byteArrayToDecimalString(message));
    }



}
