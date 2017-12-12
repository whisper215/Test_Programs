

public class LongTest {
    public LongTest() {
    }
        //int bit_num = Long.bitCount(Long.MAX_VALUE);
        //int byte_num = Long.BYTES;
        //int size = Long.SIZE;

        //System.out.println("bit_num, " + bit_num);
        //System.out.println("byte_num, " + byte_num);
        //System.out.println("size, " + size);

        //System.out.println("byte size," + Byte.SIZE + " max byte = " + Byte.MAX_VALUE);

    public byte[] encode() {
        byte[] val = new byte[512];
        byte[] len = new byte[2];

        if (val.length < 0xFF) {
            len[0] = (byte) val.length;
            len[1] = 0x00;
        } else if (val.length < (0x0FFFF)){
            System.out.println("val.length, " + String.format("0x%x", val.length));
            len[0] = (byte)(0x0FF & val.length);
            len[1] = (byte)(0x0FF & (val.length >> 8));
        }

        System.out.println("0xFF =  " + 0x1FFFF);
        System.out.println("len , " + len[0] + ", " + len[1]);

        return len;
    }

    public void decode(byte[] len) {
        int val = 0;

        val = (int)(len[1]<<8 | len[0]);
        System.out.println("decode val =  " + val);
    }

    public static void main(String argv[]) {
        LongTest test = new LongTest();
        byte[] len = test.encode();
        test.decode(len);
    }
}
