package cleanData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class cleanDataMain {
    public static void main(String args[]) throws Exception
    {
        Configuration c=new Configuration();
        String[] paths=new GenericOptionsParser(c,args).getRemainingArgs();
        Path input=new Path(paths[0]);
        Path output=new Path(paths[1]);
        Job j=new Job(c,"clean_data_job");

        j.setPartitionerClass(cleanDataPartitioner.class);

        j.setNumReduceTasks(2);

        j.setJarByClass(cleanDataMain.class);

        j.setMapperClass(cleanDataMap.class);

        j.setReducerClass(cleanDataReduce.class);

        j.setMapOutputKeyClass(Text.class);

        j.setMapOutputValueClass(IntWritable.class);

        j.setOutputKeyClass(Text.class);

        j.setOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(j, input);

        FileOutputFormat.setOutputPath(j, output);

        System.exit(j.waitForCompletion(true)?0:1);
    }
}
