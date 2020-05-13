package io.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamTest {

    public static void main(String[] args) throws IOException {
//        inputStream();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (byte byteTmp = 48; byteTmp <= 57; byteTmp++) {
            outputStream.write(byteTmp);
        }
        System.out.println(outputStream.toString());

    }

    private static void inputStream() throws IOException {
        byte[] bytes = "0123456789abcdefghijklmnopqrstuvwxyz".getBytes();
        printByteArray(bytes);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        System.out.println(inputStream.available());
        System.out.println(inputStream.markSupported());
        System.out.println(inputStream.read());

        byte[] tmp = new byte[2];
        System.out.println(inputStream.read(tmp));
        printByteArray(tmp);

        inputStream.mark(-1);
        System.out.println(inputStream.read());
        System.out.println(inputStream.available());
        System.out.println(inputStream.skip(10));
        System.out.println(inputStream.available());
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        System.out.println(inputStream.available());

        inputStream.reset();
        System.out.println(inputStream.available());
        System.out.println(inputStream.read());
    }

    private static void printByteArray(byte[] bytes) {
        System.out.print("=========");
        for (byte byteTmp : bytes) {
            System.out.print(byteTmp + " ");
        }
        System.out.println("=========");
    }
}


