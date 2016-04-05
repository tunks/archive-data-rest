package com.att.archive.restful.util;

import java.io.IOException;
import java.util.List;
/**
 * ArchiveFactory interface 
 * @param <T>
 * @param <V>
 **/
public interface ArchiveFactory<T,V>{
    public List<V> create(T object) throws IOException;
    public List<V> create(List<T> object) throws IOException;
    public List<V> create(List<T> archives, IArchiver archiver) throws IOException;
}