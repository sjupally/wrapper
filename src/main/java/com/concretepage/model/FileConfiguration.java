package com.concretepage.model;

import java.util.List;

/**
 * Created by Srikanth on 5/26/2017.
 */
public class FileConfiguration {
    private String filePath;
    private List<FieldDTO> fieldList;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<FieldDTO> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FieldDTO> fieldList) {
        this.fieldList = fieldList;
    }
}
