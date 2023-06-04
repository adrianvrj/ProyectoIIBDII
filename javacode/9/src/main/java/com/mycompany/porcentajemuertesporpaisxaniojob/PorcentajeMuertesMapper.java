/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porcentajemuertesporpaisxaniojob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PorcentajeMuertesMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private final Text countryAndYear = new Text();
    private final FloatWritable count = new FloatWritable();
    private boolean isFirstLine = true;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (isFirstLine) {
            isFirstLine = false;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",");
        String country = fields[0];
        String year = fields[1];
        float death = Float.parseFloat(fields[2].substring(1, 4));

        countryAndYear.set(country + "," + year);
        count.set(death);

        context.write(countryAndYear, count);
    }
}
