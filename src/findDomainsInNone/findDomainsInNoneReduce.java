package findDomainsInNone;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class findDomainsInNoneReduce extends Reducer<Text,IntWritable,Text,IntWritable> {
    public void reduce(Text text,Iterable<IntWritable >values,Context context) throws IOException, InterruptedException {
        int sum=0;
        for (IntWritable itr :values){
            sum=sum+itr.get();
        }
        context.write(text,new IntWritable(sum));
    }

}
