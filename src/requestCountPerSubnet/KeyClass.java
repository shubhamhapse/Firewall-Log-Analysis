package requestCountPerSubnet;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

class KeyClass implements WritableComparable<KeyClass> {

    Text timestamp;
    Text catagory;
    Text ip;

    public KeyClass(Text timestamp, Text catagory, Text ip) {
        this.timestamp=(timestamp);
        this.catagory=(catagory);
        this.ip=(ip);

    }
    public KeyClass()
    {
        timestamp=new Text();

        catagory=new Text();
        ip=new Text();
    }


    public void write(DataOutput out) throws IOException {
        this.timestamp.write(out);

        this.catagory.write(out);
        this.ip.write(out);

    }


    public void readFields(DataInput in) throws IOException {

        this.timestamp.readFields(in);
        this.catagory.readFields(in);
        this.ip.readFields(in);
        ;

    }


    public int compareTo(KeyClass pop) {
        if (pop == null)
            return 0;
        String ip1[]=ip.toString().split("\\.");
      //  System.out.println(ip.toString().split("")+"  checking");
        String ip2[]=pop.ip.toString().split("\\.");
        String s1=timestamp.toString().split(":")[0]+","+ catagory.toString()+","+ip1[0]+"."+ip1[1]+"."+ip1[2];
        String s2=pop.timestamp.toString().split(":")[0]+","+ pop.catagory.toString()+","+ip2[0]+"."+ip2[1]+"."+ip2[2];
        int intcnt = s1.compareTo(s2);
        if (intcnt != 0) {
            return intcnt;
        } else {
            return 0;

        }
    }


    @Override
    public String toString() {
        String ipString[]=ip.toString().split("\\.");
        return timestamp.toString().split(":")[0]+"," + ipString[0]+"."+ ipString[1]+"."+ ipString[2]+ "," +  catagory.toString();
    }
}