package jsmacro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Ben Cochrane
 */
public class RecordModel {
    
    private ArrayList<Record> records;
    private int activeRecord;
    
    public RecordModel(File f) throws FileNotFoundException, IOException {
        records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = br.readLine();
        
        while (line != null) {
            if (!line.isEmpty()) {
                records.add(new Record(line.split(",")));
            }
            line = br.readLine();
        }
        br.close();
        
    }
    
    public int getActiveRecord() {
        return activeRecord;
    }
    
    public void setActiveRecord(int n) {
        activeRecord = n >= 0 ? n < records.size() ? n : records.size() - 1 : 0;
    }
    
    public int getRecordSize() {
        return records.get(activeRecord).length();
    }
    
    public int getNumberOfRecords() {
        return records.size();
    }
    
    public void increment() {
        activeRecord = activeRecord < records.size() - 1 ? activeRecord + 1 : records.size() - 1;
    }
    
    public void decrement() {
        activeRecord = activeRecord > 1 ? activeRecord - 1 : 0;
    }
    
    private class Record {
        
        public String[] data;
       
        public Record(String[] data) {
            this.data = data.clone();
        }
        
        public int length() {
            return data.length;
        }
        
    }
}
