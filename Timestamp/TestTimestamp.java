import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestTimestamp {
    public TestTimestamp() {
        while (true) {
            Timestamp ts_1 = new Timestamp(System.currentTimeMillis());
            Timestamp ts_2 = new Timestamp(System.nanoTime() / 1000000);
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH:mm:ss.SSS");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

            String str_time = sdf.format(ts_1);
            System.out.println("ts_1, " + ts_1);
            System.out.println("ts_1, " + str_time);

            str_time = sdf.format(ts_2);
            System.out.println("ts_2, " + ts_2);
            System.out.println("ts_2, " + str_time);

            Timestamp ts_3 = new Timestamp(ts_1.getTime());
            str_time = sdf.format(ts_3);
            System.out.println("ts_3, " + ts_3);
            System.out.println("ts_3, " + str_time);

            Timestamp ts_4 = new Timestamp(ts_1.getNanos() / 1000000);
            str_time = sdf.format(ts_3);
            System.out.println("ts_4, " + ts_3);
            System.out.println("ts_4, " + str_time);

            System.out.println("--------------");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        //long ts_1 = 17180810931000L;
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH:mm:ss.SSS");

        //String str_time = sdf.format(ts_1/1000000);
        //System.out.println(ts_1);
        //System.out.println(str_time);
        
    }

    public static void main(String argv[]) {
        TestTimestamp ts = new TestTimestamp();
    }
}
