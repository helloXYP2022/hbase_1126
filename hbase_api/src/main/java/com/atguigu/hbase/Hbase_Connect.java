package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class Hbase_Connect {
    public static void main(String[] args) throws IOException {
        //1.创建配置对象，2设置配置属性


        //创建配置对象
        //方法一：
//        Configuration conf = new Configuration();//hconnection-0x3835c46
        //方法二：
//        Configuration conf = HBaseConfiguration.create();//hconnection-0x43195e57

        //设置配置属性
//       conf.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");

        //方法三：
//        Configuration conf = HBaseConfiguration.create();//hconnection-0x188715b5
        //添加hbase集群的hbase-site.xml文件到resources目录中
//      打包到代码到集群上有可能需要类加载器？

        //3.通过连接工厂创建连接
//        Connection connection = ConnectionFactory.createConnection(conf);
        Connection connection = ConnectionFactory.createConnection();//hconnection-0x188715b5
        System.out.println(connection);

        Class<String> stringClass = String.class;
    }
}
