/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.promediominmaxhomicidiossubregionsexoanio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class HomicidiosRunner {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "hadoop-mysql-connector");

        // Set the driver class for MySQL
        job.getConfiguration().set("mapreduce.jdbc.driver.class", "com.mysql.jdbc.Driver");

        // Set the connection URL, username, and password for MySQL
        job.getConfiguration().set("mapreduce.jdbc.url", "jdbc:mysql://localhost:3306/hadoopreducer");
        job.getConfiguration().set("mapreduce.jdbc.username", "root");
        job.getConfiguration().set("mapreduce.jdbc.password", "root");

        job.setJarByClass(HomicidiosRunner.class);
        job.setMapperClass(HomicidiosMapper.class);
        job.setCombinerClass(HomicidiosReducer.class);
        job.setReducerClass(HomicidiosReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        if (job.waitForCompletion(true)) {
            insertIntoMySQL(args[1]); // Llama al método para insertar los datos en MySQL
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

    private static void insertIntoMySQL(String outputPath) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/hadoopreducer"; // Reemplaza con tu URL de conexión de MySQL
        String username = "root";
        String password = "password";

        String insertQuery = "INSERT INTO `homicides_min_max_subregion_sexo_anio` (subregion, sexo, anio, min, max, promedio) VALUES (?, ?, ?, ?, ?, ?)";

        try ( Connection connection = DriverManager.getConnection(url, username, password);  PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Lee los resultados del archivo de salida del MapReduce
            Path outputFilePath = new Path(outputPath + "/part-r-00000");
            FileSystem fs = FileSystem.get(new Configuration());
            BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(outputFilePath)));

            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "\t");
                String[] keys = tokenizer.nextToken().split(",");
                String[] valores = tokenizer.nextToken().split(",");
                String region = keys[0];
                String sexo = keys[1];
                String anio = keys[2];
                
                float promedio = Float.parseFloat(valores[0]);
                float min = Float.parseFloat(valores[1]);
                float max = Float.parseFloat(valores[2]);
                // Establece los parámetros en la declaración preparada
                statement.setString(1, region);
                statement.setString(2, sexo);
                statement.setString(3, anio);
                statement.setFloat(4, min);
                statement.setFloat(5, max);
                statement.setFloat(6, promedio);
                // Ejecuta la inserción en la base de datos
                statement.executeUpdate();
            }

            System.out.println("Datos insertados en la base de datos MySQL.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
