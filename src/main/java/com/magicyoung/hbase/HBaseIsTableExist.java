package com.magicyoung.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author: magicyoung
 * @Date: 2019/2/22 14:28
 * @Description: 通过客户端判断表是否存在
 */
public class HBaseIsTableExist {
    public static void isTableExistByClient() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "hadoop4,hadoop5,hadoop6");

        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();

        boolean result = admin.tableExists(TableName.valueOf("student"));

        admin.close();

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        isTableExistByClient();
    }
}
