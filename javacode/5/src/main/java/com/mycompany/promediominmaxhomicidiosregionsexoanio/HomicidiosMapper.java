/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediominmaxhomicidiosregionsexoanio;

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
        String region = fields[0];
        String sexo = fields[3];
        int anio = 2000;
        for(int i = 5; i <= 25; i++){
            if("".equals(fields[i])){
                continue;
            }
            if(!esNumero(fields[i])){
                continue;
            }
            
            pais.set(region + "," + sexo + "," + String.valueOf(anio));
            count.set(fields[i]);

            context.write(pais, count);
            anio++;
        }
    }
    
    public boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true; // El string es un número
        } catch (NumberFormatException e) {
            return false; // El string no es un número
        }
    }
}
