package com.wchg;

import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 王朝刚
 * @date 2017/6/19 1:03
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
