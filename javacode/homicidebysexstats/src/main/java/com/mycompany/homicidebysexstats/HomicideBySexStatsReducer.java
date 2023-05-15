/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homicidebysexstats;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author adrianvargas
 */
public class HomicideBySexStatsReducer extends Reducer<Text, IntWritable, Text, FloatWritable> {

    private FloatWritable average = new FloatWritable();
    private FloatWritable minimum = new FloatWritable();
    private FloatWritable maximum = new FloatWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (IntWritable val : values) {
            int numHomicides = val.get();
            sum += numHomicides;
            count++;

            if (numHomicides < min) {
                min = numHomicides;
            }

            if (numHomicides > max) {
                max = numHomicides;
            }
        }

        float avg = (float) sum / count;
        average.set(avg);
        minimum.set(min);
        maximum.set(max);

        context.write(key, average);
        context.write(key, minimum);
        context.write(key, maximum);
    }
}
