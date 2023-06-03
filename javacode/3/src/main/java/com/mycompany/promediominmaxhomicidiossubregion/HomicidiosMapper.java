/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediominmaxhomicidiossubregion;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HomicidiosMapper extends Mapper<Object, Text, Text, Text> {
    private final Text pais = new Text();
    private final Text count = new Text();
    private int skiplines = 3;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (skiplines != 0) {
            skiplines--;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        
        if(fields.length < 24){
            return;
        }
        String country = fields[1];
        String valuestr = "";
        for(int i = 4; i <= 24; i++){
            if(fields[i] == ""){
                continue;
            }
            if(i == 24){
                valuestr += fields[i];
                break;
            }
            valuestr += fields[i] + ",";
        }

        pais.set(country);
        count.set(valuestr);

        context.write(pais, count);
    }
}
