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
    
    public String get(int n) {
        return records.get(activeRecord).data[n >= 0 ? n < recordSize() ? n : recordSize() - 1 : 0];
    }
    
    public int record() {
        return activeRecord;
    }
    
    public void setRecord(int n) {
        activeRecord = n >= 0 ? n < records.size() ? n : records.size() - 1 : 0;
    }
    
    public int recordSize() {
        return records.get(activeRecord).length();
    }
    
    public int numRecords() {
        return records.size();
    }
    
    public void next() {
        activeRecord = activeRecord < records.size() - 1 ? activeRecord + 1 : records.size() - 1;
    }
    
    public void previous() {
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
