/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homicidebysexstats;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author adrianvargas
 */
public class HomicideBySexStatsMapper extends Mapper<Object, Text, Text, IntWritable> {

    private Text regionGenderDecade = new Text();
    private IntWritable count = new IntWritable();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        if (fields.length >= 24) {
            String region = fields[0];
            String gender = fields[3];
            int numHomicides1 = 0;
            for (int i = 5; i <= 15; i++) {
                if(fields[i].isEmpty()){
                    continue;
                }
                int valorEntero = Integer.parseInt(fields[i]);
                numHomicides1 += valorEntero;
            }
            int numHomicides2 = Integer.parseInt(fields[5]);
            for (int i = 16; i <= 25; i++) {
                if(fields[i].isEmpty()){
                    continue;
                }
                int valorEntero = Integer.parseInt(fields[i]);
                numHomicides2 += valorEntero;
            }
            regionGenderDecade.set(region + "," + gender + "," + "2000s");
            count.set(numHomicides1);
            context.write(regionGenderDecade, count);
            regionGenderDecade.set(region + "," + gender + "," + "2010s");
            count.set(numHomicides2);
            context.write(regionGenderDecade, count);
        }
    }

}
