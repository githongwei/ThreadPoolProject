package com.pack.util.dbcp.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 娃哈哈
 * 数据源切换
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {
        String type = DataSourceContextHolder.getDataSourcesType();
        System.out.println("连接类型为："+type);
        return type;
    }
}
