package com.atguigu.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class Hbase_DML {

    public static Connection connection=Hbase_ConnectSingle.connection;

    public static void putCell(String nameSpace,String tableName,String family,String rowKey,String column,String value) throws IOException {

        Table table = connection.getTable(TableName.valueOf(nameSpace, tableName));

        Put put = new Put(Bytes.toBytes(rowKey));

        put.addColumn(Bytes.toBytes(family),Bytes.toBytes(column),Bytes.toBytes(value));

        table.put(put);

        table.close();
    }



    public static void main(String[] args) throws IOException {

        putCell("bigdata","stu","info","1001","name","panjinlian");

        Hbase_ConnectSingle.closeConnect();


    }
}
