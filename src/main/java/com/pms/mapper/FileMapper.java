package com.pms.mapper;

import com.pms.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public void addFile(File file);
    public void deleteFile(int fileId);
    public void updateFile(int fileId);
    public File findById(int fileId);
    public File findByName(String fileName);
    public List<File> findByStatus(int fileStatus);
    public List<File> findAllFile();
}
