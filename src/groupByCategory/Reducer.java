package groupByCategory;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public  class Reducer extends org.apache.hadoop.mapreduce.Reducer<User,IntWritable,User,IntWritable>{
    public void reduce(User user,Iterable<IntWritable> values,Context context) throws IOException,InterruptedException{
        int sum=0;
        for(IntWritable itr: values)
        {
            sum=sum+itr.get();
        }
        context.write(user,new IntWritable(sum));
    }



}
