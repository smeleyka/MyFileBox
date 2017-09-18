package ru.smeleyka.myfilebox.shared_classes;

/**
 * Created by smele on 17.09.2017.
 */
public class FileDataMessage extends AbstractMessage {
    private String fileName;
    private int fileSize;
    private byte[] fileData;

    public FileDataMessage(String fileName, int fileSize, byte[] fileData) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
