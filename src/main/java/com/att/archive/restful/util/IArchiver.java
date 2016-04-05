package com.att.archive.restful.util;

import com.att.archive.restful.model.ArchiveEntity;
import java.io.IOException;

/**
 *
 * @author ebrima
 * @param <T>
 */
public interface IArchiver<T>{
    public void compress(T input) throws IOException;
    public void compress(T input ,ArchiveEntity archive) throws IOException;
    public String decompress(ArchiveEntity archive) throws IOException;
}
