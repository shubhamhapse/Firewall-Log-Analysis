package requestCountPerSubnet;
import cleanData.cleanDataPartitioner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class requestCountMain {
    public static void main(String args[]) throws Exception
    {
        Configuration c=new Configuration();
        String[] paths=new GenericOptionsParser(c,args).getRemainingArgs();
        Path input=new Path(paths[0]);
        Path output=new Path(paths[1]);

        Job j=new Job(c,"request_count_per_subnet_job");
        j.setJarByClass(requestCountMain.class);

        j.setMapperClass(requestCountMap.class);

        j.setReducerClass(requestCountReduce.class);

        j.setMapOutputKeyClass(Text.class);

        j.setMapOutputValueClass(IntWritable.class);

        j.setOutputKeyClass(Text.class);

        j.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(j, input);

        FileOutputFormat.setOutputPath(j, output);

        System.exit(j.waitForCompletion(true)?0:1);
    }
}
