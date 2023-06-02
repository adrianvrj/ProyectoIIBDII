/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediohomicidiospaissexojob;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class HomicidiosReducer extends Reducer<Text, Text, Text, Text> {

    private final Text result = new Text();

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int total = 0;
        int nvalues = 0;
        for (Text value : values) {
            String[] numeros = value.toString().split(",");
            for(String numero : numeros){
                if(!numero.isEmpty()){
                    total += Float.parseFloat(numero);
                    nvalues++;
                }
            }
        }
        float res = total/nvalues;
        result.set(String.valueOf(res));
        context.write(key, result);
    }
}
