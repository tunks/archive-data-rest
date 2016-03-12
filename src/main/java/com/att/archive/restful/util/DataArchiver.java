
package com.att.archive.restful.util;

import com.att.archive.restful.model.Archive;
import com.migcomponents.migbase64.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/**
 * Data archiver concrete implementation
 * @author ebrima
 */

public class DataArchiver implements IArchiver<String> {
    //compress the input string
    @Override
    public void compress(String input, Archive archive) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(input.length());
        GZIPOutputStream out = new GZIPOutputStream(os);
        out.write(input.getBytes(StandardCharsets.UTF_8));
        out.close();
        byte[] compressed = os.toByteArray();
        os.close();
        archive.setCompressedData(Base64.encodeToByte(compressed,false));
        archive.setCompressedType("gzip");
    }
    //decompress the archive byte
    @Override
    public String decompress(Archive archive) throws IOException {
        final int BUFFER_SIZE = 32;
        byte[] compressed = Base64.decodeFast(archive.getCompressedData());
        StringBuilder string;
        try (ByteArrayInputStream is = new ByteArrayInputStream(compressed)) {
            GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
            string = new StringBuilder();
            byte[] data = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = gis.read(data)) != -1) {
                string.append(new String(data, 0, bytesRead));
            }   gis.close();
        }
        return string.toString();
    }

    @Override
    public void compress(String input) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
