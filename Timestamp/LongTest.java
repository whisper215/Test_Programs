

public class LongTest {
    public LongTest() {
        int bit_num = Long.bitCount(Long.MAX_VALUE);
        int byte_num = Long.BYTES;
        int size = Long.SIZE;

        System.out.println("bit_num, " + bit_num);
        System.out.println("byte_num, " + byte_num);
        System.out.println("size, " + size);

        System.out.println("byte size," + Byte.SIZE + " max byte = " + Byte.MAX_VALUE);
    }

    public static void main(String argv[]) {
        LongTest test = new LongTest();
    }
}
