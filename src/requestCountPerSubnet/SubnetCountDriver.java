package requestCountPerSubnet;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class SubnetCountDriver {
    public static void main(String args[]) throws Exception{
        Configuration c=new Configuration();
        String []paths= new GenericOptionsParser(c,args).getRemainingArgs();
        Path inputPath=new Path(paths[0]);
        Path outputPath=new Path(paths[1]);

        Job j=new Job(c,"groupbysubnet");

        j.setJarByClass(SubnetCountDriver.class);
        j.setMapperClass(Mapper.class);
        j.setReducerClass(Reducer.class);

        j.setMapOutputKeyClass(KeyClass.class);

        j.setMapOutputValueClass(IntWritable.class);

        j.setOutputKeyClass(KeyClass.class);

        j.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(j, inputPath);

        FileOutputFormat.setOutputPath(j, outputPath);

        System.exit(j.waitForCompletion(true)?0:1);
    }
}
