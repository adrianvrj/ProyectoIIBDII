/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diferenciaedadjob;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EdadReducer extends Reducer<Text, Text, Text, Text> {

    private final Text result = new Text();

    public void reduce(Text key, Iterable<Text> vals, Context context) throws IOException, InterruptedException {
        int ultimoAnio = 900000;
        float valorultimo = 0;
        int primerAnio = 0;
        float valorprimero = 0;
        for (Text values : vals) {
            String[] valores = values.toString().split(",");
            if(valores.length < 2){
                continue;
            }
            if (Integer.parseInt(valores[1]) > ultimoAnio) {
                ultimoAnio = Integer.parseInt(valores[1]);
                valorultimo = Float.parseFloat(valores[0]);
            }
            if (Integer.parseInt(valores[1]) < primerAnio) {
                primerAnio = Integer.parseInt(valores[1]);
                valorprimero = Float.parseFloat(valores[0]);
            }
        }

        float valor = valorprimero - valorultimo;
        result.set(String.valueOf(valor));
        context.write(key, result);
    }
}
