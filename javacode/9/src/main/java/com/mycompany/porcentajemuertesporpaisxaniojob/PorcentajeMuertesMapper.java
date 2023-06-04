/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porcentajemuertesporpaisxaniojob;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PorcentajeMuertesMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private Text countryYear = new Text();
    private FloatWritable deathCount = new FloatWritable();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Parsear la línea del archivo de entrada
        String[] fields = value.toString().split(",");

        // Obtener los campos relevantes (país, año, edad, causa de muerte, total de muertes)
        String country = fields[0];
        String year = fields[1];
        int age = Integer.parseInt(fields[2]);
        String cause = fields[3];
        int deaths = Integer.parseInt(fields[4]);

        // Filtrar por causa de muerte (cáncer) y rango de edad (30 a 70)
        if (cause.equalsIgnoreCase("cancer") && age >= 30 && age <= 70) {
            // Crear la clave compuesta por país y año
            countryYear.set(country + "_" + year);
            deathCount.set(deaths);

            // Emitir el par clave-valor (countryYear, deathCount)
            context.write(countryYear, deathCount);
        }
    }
}
