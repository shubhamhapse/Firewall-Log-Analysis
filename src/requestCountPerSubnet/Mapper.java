package requestCountPerSubnet;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;


public   class Mapper extends org.apache.hadoop.mapreduce.Mapper <LongWritable, Text, KeyClass,IntWritable>
{

    public void map(LongWritable longWritable,Text text,Context context) throws InterruptedException,IOException{
        String data[]=text.toString().split(",");
        {
            KeyClass keyClass;
             keyClass =new KeyClass(new Text(data[0]),new Text(data[3]),new Text(data[4]));
            context.write(keyClass, new IntWritable(1));
        }
    }
}
