package com.pack.util.dbcp.datasource;

/**
 * @author 娃哈哈
 * 数据源处理类
 */
public class DataSourceContextHolder {
    /**
     * 本地数据源
     */
    public static final String MASTER_DATA_SOURCES="masterDataSource";
    /**
     * 远程数据源
     */
    public static final String SLAVE_DATA_SOURCES="slaveDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源名称
     * @param dataSources
     */
    public static void setDataSources(String dataSources){
        contextHolder.set(dataSources);
    }

    /**
     * 获取连接类型
     * @return
     */
    public static String getDataSourcesType(){
        return contextHolder.get();
    }

    /**
     * 清除
     */
    public static void clear(){
        contextHolder.remove();
    }
}
