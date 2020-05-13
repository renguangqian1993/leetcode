package io.stream;

import java.io.*;
import java.util.Arrays;

public class FileStreamTest {

    public static String filePath = "/home/renguangqian/IdeaProjects/leetcode/src/test/java/io/stream/fileStream.text";

    public static void main(String[] args) throws Exception {
//        for (int index = 0; index <= 1000; index++) {
//            Writer writer = new Writer(filePath);
//            writer.start();
//
//            Reader reader = new Reader(filePath);
//            reader.start();
//        }

        Reader reader = new Reader(filePath);
        reader.start();
    }

    private static class Reader extends Thread {
        private InputStream inputStream;

        public Reader(String filePath) {
            try {
                this.inputStream = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {

                int available = inputStream.available();
                System.out.println("available : " + available);
                while (true) {
                    byte[] bytes = new byte[1024];

                    int len = inputStream.read(bytes);
                    if (len <= 0) {
                        break;
                    }

                    System.out.print(new String(Arrays.copyOf(bytes, len)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                    inputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Writer extends Thread {
        private OutputStream outputStream;

        public Writer(String filePath) {
            try {
                this.outputStream = new FileOutputStream(filePath, true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            try {
                outputStream.write("0123456789".getBytes());
                outputStream.write("abcdefghijklmnopqrstuvwxyz".getBytes());
                outputStream.write("\r\n".getBytes());
                System.out.println("Writer finished");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.flush();
                    outputStream.close();
                    outputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
