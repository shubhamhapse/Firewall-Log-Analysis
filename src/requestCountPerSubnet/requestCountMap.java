package requestCountPerSubnet;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class requestCountMap extends Mapper<LongWritable,Text,Text,IntWritable>{
    public void map(LongWritable longWritable,Text text,Context context) throws InterruptedException,IOException
    {
        String s=text.toString();
        String data[]=s.split(",");

        context.write(new Text(data[6]), new IntWritable(1));

    }

}
