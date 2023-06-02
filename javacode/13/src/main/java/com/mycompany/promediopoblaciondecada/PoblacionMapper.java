/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediopoblaciondecada;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PoblacionMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final Text decade = new Text();
    private final IntWritable count = new IntWritable();
    private boolean isFirstLine = true;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (isFirstLine) {
            isFirstLine = false;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",");
        String year = fields[1].substring(1,4) + "0s";
        String valuestr = "";
        for(int i = 1; i <= 100; i++){
            if(fields[2].charAt(i) == '"'){
                break;
            }
            valuestr += fields[2].charAt(i);
        }
        int porcentage = Integer.parseInt(valuestr);

        decade.set(year);
        count.set(porcentage);

        context.write(decade, count);
    }
}
