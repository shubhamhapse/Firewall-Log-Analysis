package findDomainsInNone;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class findDomainsInNoneMap extends Mapper<LongWritable,Text,Text,IntWritable>{
    public void map(LongWritable longWritable,Text text,Context context) throws InterruptedException,IOException
    {
        String temp=text.toString();
        String inp[]=temp.split(",");
        if(inp[3].equals("None"))
        context.write(new Text(inp[2]), new IntWritable(1));

    }

}
