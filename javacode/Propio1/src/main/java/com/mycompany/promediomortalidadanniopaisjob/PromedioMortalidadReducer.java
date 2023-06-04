/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediomortalidadanniopaisjob;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PromedioMortalidadReducer extends Reducer<Object, Text, Text, FloatWritable> {
    private final FloatWritable result = new FloatWritable();
    
    public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        int totalMortalidad = 0;
        int nValues = 0;
        for (FloatWritable value : values) {
            totalMortalidad += value.get();
            nValues++;
        }
        float valor = (float) totalMortalidad/nValues;
        result.set(valor);
        System.out.print(key);
        context.write(key, result);
    }
}

