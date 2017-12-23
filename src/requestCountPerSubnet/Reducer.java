package requestCountPerSubnet;

import org.apache.hadoop.io.IntWritable;

import java.io.IOException;

public  class Reducer extends org.apache.hadoop.mapreduce.Reducer<KeyClass,IntWritable, KeyClass,IntWritable>{
    public void reduce(KeyClass keyClass, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException{
        int sum=0;
        for(IntWritable itr: values)
        {
            sum=sum+itr.get();
        }
        context.write(keyClass,new IntWritable(sum));
    }



}
