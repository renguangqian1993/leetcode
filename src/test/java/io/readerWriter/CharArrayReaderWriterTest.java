package io.readerWriter;

import org.junit.Test;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

public class CharArrayReaderWriterTest {

    @Test
    public void writerTest() {
        String str = "0123456789abcdefghijklmnopqrstuvwxyz";
        char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();

        CharArrayWriter writer = new CharArrayWriter();
        for (int index = 0; index < str.length(); index++) {
            if (index % 2 == 0) {
                writer.write(bytes[index]);
            } else {
                writer.append(chars[index]);
            }
        }

        char[] charArray = writer.toCharArray();
        System.out.println(String.valueOf(charArray));
    }

    @Test
    public void readerTest() throws Exception {
        CharArrayReader reader = new CharArrayReader("0123456789abcdefghijklmnopqrstuvwxyz".toCharArray());
        reader.mark(0);

        {
            char[] chars = new char[1024];
            int len = reader.read(chars);
            if (len > 0) {
                System.out.println(String.valueOf(chars, 0, len));
            }
        }

        {
            StringBuilder stringBuilder = new StringBuilder();
            reader.reset();
            char[] chars = new char[10];
            int len;
            while ((len = reader.read(chars)) > 0) {
                stringBuilder.append(String.valueOf(chars, 0, len));
            }
            System.out.println(stringBuilder.toString());

        }
    }

}
