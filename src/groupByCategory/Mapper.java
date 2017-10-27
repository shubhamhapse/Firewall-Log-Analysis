package groupByCategory;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;


public   class Mapper extends org.apache.hadoop.mapreduce.Mapper <LongWritable, Text, User,IntWritable>
{

    public void map(LongWritable longWritable,Text text,Context context) throws InterruptedException,IOException{
        String data[]=text.toString().split(",");
     //   if(data.length==6);
        {
            User user;
             user=new User(new Text(data[0]),new Text(data[1]),new Text(data[2])
                    ,new Text(data[3]),new Text(data[4]),new Text(data[5]));
            context.write(user, new IntWritable(1));
        }
    }
}
