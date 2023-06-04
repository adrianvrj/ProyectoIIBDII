/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediopoblacionporanniojob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PromedioPoblacionMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private final Text year = new Text();
    private final FloatWritable count = new FloatWritable();
    private boolean isFirstLine = true;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (isFirstLine) {
            isFirstLine = false;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",");
        if(fields.length < 3){
            return;
        }
        
        String yearData = fields[1];
        String valstr = "";
        for(int i = 1; fields[2].charAt(i) != '"'; i++){
            valstr += fields[2].charAt(i);
        }
        float val = Float.parseFloat(valstr);
        year.set(yearData);
        count.set(val);

        context.write(year, count);
    }
}

