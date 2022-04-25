package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class Hbase_ConnectSingle {

    public static Connection connection=null;
    static{
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");
        try {
            connection=ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnect() throws IOException {
        if(connection!=null)
            connection.close();
    }
    public static void main(String[] args) {

        System.out.println("hellogit");
        System.out.println("hot-fix");

    }
}
