package com.att.archive.restful.util;

import com.att.archive.restful.model.Archive;
import java.io.IOException;

/**
 *
 * @author ebrima
 */
public interface IArchiver<T1>{
    public void compress(T1 input) throws IOException;
    public void compress(T1 input ,Archive archive) throws IOException;
    public String decompress(Archive archive) throws IOException;
}
