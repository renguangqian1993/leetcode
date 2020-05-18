package io.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PipedStreamTest {
    public static void main(String[] args) {
        Sender t1 = new Sender();

        Receiver t2 = new Receiver();

        ByteArrayOutputStream out = t1.getOutputStream();

        ByteArrayInputStream in = t2.getInputStream();

        try {

            t1.start();
            t2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Receiver extends Thread {

        private ByteArrayInputStream in = new ByteArrayInputStream(null);

        public ByteArrayInputStream getInputStream() {
            return in;
        }

        @Override
        public void run() {
//        readMessageOnce() ;
            readMessageContinued();
        }

        public void readMessageOnce() {
            byte[] buf = new byte[2048];
            try {
                int len = in.read(buf);
                System.out.println(new String(buf, 0, len));
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readMessageContinued() {
            while (true) {
                byte[] buf = new byte[1024];
                try {
                    int len = in.read(buf);
                    if (len < 0) {
                        break;
                    }

                    System.out.println(new String(buf, 0, len));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sender extends Thread {

        private ByteArrayOutputStream out = new ByteArrayOutputStream();

        public ByteArrayOutputStream getOutputStream() {
            return out;
        }

        @Override
        public void run() {
//        writeShortMessage();
            writeLongMessage();
        }

        private void writeShortMessage() {
            String strInfo = "this is a short message";
            try {
                out.write(strInfo.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void writeLongMessage() {
            StringBuilder sb = new StringBuilder();
            // 通过for循环写入1020个字节
            for (int i = 0; i < 102; i++) {
                sb.append("0123456789");
            }

            // 再写入26个字节。
            sb.append("abcdefghijklmnopqrstuvwxyz");

            // str的总长度是1020+26=1046个字节
            String str = sb.toString();
            try {
                out.write(str.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


