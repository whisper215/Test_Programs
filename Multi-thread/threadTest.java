import java.util.Scanner;

public class threadTest {

    public threadTest() {
        runningThread rt = new runningThread();
        rt.start();

    }

    public static void main(String args[]) {
        System.out.println("Java test : ");
        new threadTest();
    }

    private class runningThread extends Thread {
        protected boolean stopFlag = false;
        private int counter = 0;
        private Scanner scanner;
        private interruptThread it;

        public runningThread() {
            this.stopFlag = false;
            this.counter = 0;
            this.scanner = new Scanner(System.in);
            this.it = new interruptThread(this);

        };

        protected void stopRunning() {
            this.stopFlag = true;
            counter = 0;
            scanner.close();
            System.out.println("stopRunning called.");
        }

        public void run() {
            it.start();

            while (!stopFlag) {
                System.out.println("counter : " + counter++);

                String line = scanner.next();
                //System.out.println(line);

                if (line.equals("end")) {
                    System.out.println("end command received");
                    it.interrupt();
                    stopFlag = true;
                } else {
                    System.out.println("keep running");
                }

            }
            it.interrupt();
        }
    }

    private class interruptThread extends Thread {
        private int timeout = 50000;
        private runningThread tc; 

        public interruptThread(runningThread t) {
            tc = t;
        }

        public void run() {
            try {
                Thread.sleep(timeout);
                tc.stopRunning();
            } catch (InterruptedException e) {
                System.out.println("interrptThread is interrupted when sleep.");
            }
        }
    }
}
