/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fertilityratecountrydecadequintiljob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FertlityMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private final Text countryAndDecade = new Text();
    private final FloatWritable count = new FloatWritable();
    private boolean isFirstLine = true;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (isFirstLine) {
            isFirstLine = false;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",");
        if(fields.length < 5){
            return;
        }
        String country = fields[0];
        String year = fields[1].substring(1,4) + "0s";
        String quintil = fields[3];
        String strval = fields[4].substring(1,4);
        float porcentage = Float.parseFloat(strval);

        countryAndDecade.set(country + "," + year + "," + quintil);
        count.set(porcentage);

        context.write(countryAndDecade, count);
    }
}
