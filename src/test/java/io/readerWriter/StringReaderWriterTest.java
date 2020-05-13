package io.readerWriter;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterTest {

    @Test
    public void readerTest() throws Exception {
        StringReader reader = new StringReader("0123456789abcdefghijklmnopqrstuvwxyz");

        System.out.println(reader.markSupported());
        System.out.println(reader.ready());

        reader.mark(0);
        System.out.println(reader.read());
        System.out.println(reader.read());

        reader.reset();
        System.out.println(reader.read());
        System.out.println(reader.read());

        reader.reset();
        char[] chars = new char[100];
        int size = reader.read(chars);
        System.out.println(String.valueOf(chars, 0, size));

        reader.close();
    }

    @Test
    public void writerTest() throws Exception {
        StringWriter writer = new StringWriter();

        byte[] bytes = "0123456789abcdefghijklmnopqrstuvwxyz".getBytes();
        for (byte byteTmp : bytes)
            writer.write(byteTmp);

        System.out.println(writer.getBuffer().toString());

        writer.close();
    }
}
