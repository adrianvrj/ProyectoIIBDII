/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.totalpersonascancerporanniojob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TotalPersonasCancerReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    private final FloatWritable result = new FloatWritable();

    public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        int total = 0;
        for (FloatWritable value : values) {
            total += value.get();
        }
        float valor = (float) total;
        result.set(valor);
        context.write(key, result);
    }
}