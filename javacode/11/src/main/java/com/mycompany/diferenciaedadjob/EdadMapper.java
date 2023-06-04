/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diferenciaedadjob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EdadMapper extends Mapper<Object, Text, Text, Text> {
    private final Text pais = new Text();
    private final Text countAndYear = new Text();
    private boolean isFirstLine = true;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (isFirstLine) {
            isFirstLine = false;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",");
        if(fields.length < 4){
            return;
        }
        String country = fields[0];
        String year = fields[1].substring(1,5);
        String valstr = "";
        for(int i = 1; fields[2].charAt(i) != '"'; i++){
            valstr += fields[2].charAt(i);
        }
        pais.set(country);
        countAndYear.set(valstr + "," + year);

        context.write(pais, countAndYear);
    }
}
