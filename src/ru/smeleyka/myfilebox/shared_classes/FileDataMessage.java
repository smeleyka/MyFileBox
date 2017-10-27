package ru.smeleyka.myfilebox.shared_classes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Created by smele on 17.09.2017.
 */
public class FileDataMessage extends AbstractMessage{
    private String fileName;
    private long fileSize;
    private byte[] fileData;

    public FileDataMessage(String fileName, long fileSize, byte[] fileData) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileData = fileData;
    }

    public FileDataMessage(Path file) throws Exception{
        this.fileName = file.getFileName().toString();
        this.fileSize = file.toFile().length();
        this.fileData = Files.readAllBytes(file);
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public byte[] getFileData() {
        return fileData;
    }

}
