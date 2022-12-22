/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskxml;

import java.util.List;

/**
 *
 * @author gamal
 */
public class TableData {

    RowOfTable rowOfTable;
    String tableName;

    public TableData(RowOfTable rowOfTable, String tableName) {
        this.rowOfTable = rowOfTable;
        this.tableName = tableName;
    }

    public TableData() {
    }

    public RowOfTable getRowOfTable() {
        return rowOfTable;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "TableData{" + "rowOfTable=" + rowOfTable + ", tableName=" + tableName + '}';
    }

    public void setRowOfTable(RowOfTable rowOfTable) {
        this.rowOfTable = rowOfTable;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    
}
