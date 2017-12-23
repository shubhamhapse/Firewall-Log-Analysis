package FindCatagories;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class findCatagoryReduce extends Reducer<Text,IntWritable,Text,NullWritable> {
    public void reduce(Text text,Iterable<IntWritable >intWritable,Context context) throws IOException, InterruptedException {

        context.write(text,NullWritable.get());
    }

}
