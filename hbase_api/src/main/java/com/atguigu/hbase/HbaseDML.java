package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseDML {
    // 设置静态属性hbase连接
    public static Connection connection = null;

    static {
        // 1. 创建配置对象
        Configuration conf = new Configuration();

        // 2. 添加配置参数
        conf.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");

        // 3. 创建hbase的连接
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void closeConnection() throws IOException {
        if (connection != null) {
            connection.close();
        }
    }


//4.3 使用连接
//        4.3.1 插入数据

    public static void putCell(String nameSpace, String tableName, String rowKey, String family, String column, String value) throws IOException {
        // 1.获取table
        Table table = connection.getTable(TableName.valueOf(nameSpace, tableName));
        // 2.创建Put对象
        Put put = new Put(Bytes.toBytes(rowKey));
        // 3.添加put属性
        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(column), Bytes.toBytes(value));
        // 4.put数据
        table.put(put);
        // 5.关闭资源
        table.close();
    }

    public static void main(String[] args) throws IOException {
        putCell("bigdata", "stu", "1001", "info", "name", "zhangsan");
    }

}
