/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edadpromediopaisdecadajob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EdadPromedioMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private final Text countryAndDecade = new Text();
    private final FloatWritable count = new FloatWritable();
    private int skiplines = 1;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (skiplines != 0) {
            skiplines--;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",");
        
        if(fields.length < 3){
            return;
        }
        String country = fields[0];
        String year = fields[1].substring(1,4) + "0s";
        String valuestr = "";
       
        float val = Float.parseFloat(valuestr);
        countryAndDecade.set(country + "," + year);
        count.set(val);

        context.write(countryAndDecade, count);
    }
}
