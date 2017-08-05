package cleanData;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class cleanDataPartitioner extends Partitioner<Text,IntWritable> {
    public int getPartition(Text text, IntWritable v, int numReduceTasks) {
    String s=text.toString();
    if(s.contains("Advertisements"))
        return 0;
    else
        return 1;
    }
}
