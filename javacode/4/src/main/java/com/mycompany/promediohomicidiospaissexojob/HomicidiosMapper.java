/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediohomicidiospaissexojob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HomicidiosMapper extends Mapper<Object, Text, Text, Text> {
    private final Text paisysexo = new Text();
    private final Text count = new Text();
    private int skiplines = 3;
    public void map(Object key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        if (skiplines != 0) {
            skiplines--;
            return; // Skip the first line
        }
        String[] fields = value.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        if(fields.length <= 25){
            return;
        }
        int ii = 5;
        int j = 25;
        String country = fields[2];
        String sex = fields[3];
        System.out.print(sex + "\n");
        if(!"Female".equals(sex) && !"Male".equals(sex)){
            sex = fields[4];
            ii++;
            j++;
        }
        String valuestr = "";
        for(int i = ii ; i <= j; i++){
            if("".equals(fields[i])){
                continue;
            }
            else if(!esNumero(fields[i])){
                continue;
            }
            if(i == 25){
                valuestr += fields[i];
                break;
            }
            valuestr += fields[i] + ",";
        }
        System.out.print(valuestr);
        paisysexo.set(country + "," + sex);
        count.set(valuestr);

        context.write(paisysexo, count);
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
