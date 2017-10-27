package ru.smeleyka.myfilebox.shared_classes;

import java.util.UUID;

/**
 * Created by smele on 17.09.2017.
 */
public class FileStructureMessage extends AbstractMessage {
    private String [] structureArr;

    public FileStructureMessage(String[] structureArr) {
        this.structureArr = structureArr;
    }

    public String[] getStructureArr() {
        return structureArr;
    }

    public void setStructureArr(String[] structureArr) {
        this.structureArr = structureArr;
    }

}
