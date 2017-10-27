package groupByCategory;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

class User implements WritableComparable<User> {

    Text timestamp;
    Text userId;
    Text group;
    Text domain;
    Text catagory;
    Text ip;

    public User(Text timestamp, Text userId,Text group,Text domain, Text catagory,Text ip) {
        this.timestamp=(timestamp);
        this.userId=(userId);
        this.group=(group);
        this.domain=(domain);
        this.catagory=(catagory);
        this.ip=(ip);

    }
    public User()
    {
        timestamp=new Text();
        userId=new Text();
        group=new Text();
        domain=new Text();
        catagory=new Text();
        ip=new Text();
    }


    public void write(DataOutput out) throws IOException {
        this.timestamp.write(out);
        this.userId.write(out);
        this.group.write(out);
        this.domain.write(out);
        this.catagory.write(out);
        this.ip.write(out);

    }


    public void readFields(DataInput in) throws IOException {

        this.timestamp.readFields(in);
        this.userId.readFields(in);
        this.group.readFields(in);
        this.domain.readFields(in);
        this.catagory.readFields(in);
        this.ip.readFields(in);
        ;

    }


    public int compareTo(User pop) {
        if (pop == null)
            return 0;
        String s1=userId.toString()+","+ catagory.toString();
        String s2=pop.userId.toString()+","+ pop.catagory.toString();
        int intcnt = s1.compareTo(s2);
        if (intcnt != 0) {
            return intcnt;
        } else {
            return 0;

        }
    }


    @Override
    public String toString() {

        return timestamp.toString() + "," + userId.toString()+","
                + group.toString()+"," + domain.toString()+","+ catagory.toString()+"," + ip.toString();
    }
}