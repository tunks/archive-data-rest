package com.att.archive.restful.util;

import com.att.archive.restful.model.Archive;
import com.migcomponents.migbase64.Base64;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

/**
 * LZ4-java compression/decompression implementation
 * @author ebrima
 */

public class Lz4DataArchiver implements IArchiver<String>{
    LZ4Factory factory = LZ4Factory.fastestInstance();
    
    @Override
    public void compress(String input) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void compress(String input, Archive archive) throws IOException {
        byte[] data =  input.getBytes(StandardCharsets.UTF_8);
        final int decompressedLength = data.length;
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);
        archive.setCompressedData(Base64.encodeToByte(compressed,false));
        setDecompressedLength(archive,decompressedLength);
    }

    @Override
    public String decompress(Archive archive) throws IOException {
        int decompressedLength = getDecompressedLength(archive);
        byte[] restored = new byte[decompressedLength];
        LZ4FastDecompressor decompressor = factory.fastDecompressor();      
        decompressor.decompress(Base64.decodeFast(archive.getCompressedData()), 0, restored, 0, decompressedLength);
        return new String(restored, StandardCharsets.UTF_8);
    }
    
    private int getDecompressedLength(Archive archive)
    {
        for(Map<String,Object> c: archive.getComposites()){
            Object obj = c.get("decompressed::length");
            if(obj != null){
               return (int) obj;     
            }
        }
       return  8192;
    }
    
    private void setDecompressedLength(Archive archive, int decompressedLength){
        Map<String,Object> compressedComposite = new HashMap();
        compressedComposite.put("decompressed::length", decompressedLength);
        archive.addComposite(compressedComposite);
    }
}
