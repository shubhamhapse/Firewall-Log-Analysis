package cleanData;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class cleanDataMap extends Mapper<LongWritable,Text,Text,IntWritable>{
    public void map(LongWritable longWritable,Text text,Context context) throws InterruptedException,IOException
    {
        String temp=text.toString();
        if(!temp.contains(",,,,,"))
            context.write(text, new IntWritable(1));

    }

}
