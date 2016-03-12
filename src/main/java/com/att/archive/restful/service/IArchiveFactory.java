package com.att.archive.restful.service;

import com.att.archive.restful.controller.ArchiveRequest;
import com.att.archive.restful.model.Archive;
import com.att.archive.restful.model.BaseArchive;
import com.att.archive.restful.util.IArchiver;
import java.io.IOException;
import java.util.List;
import org.springframework.data.domain.Page;



public interface IArchiveFactory{
    public Archive createNewArchive(String data);
    public List createObject(List<Archive> archives , String dataType, IArchiver archiver) throws IOException;
    public List<Archive> createArchives(IArchiveService service, ArchiveRequest requests);
    public Page<Archive> createArchivesWithPage(IArchiveService service, ArchiveRequest requests);
    public Page<BaseArchive> createObjectWithPage(Page<Archive> archives, IArchiver archiver) throws IOException;
}