package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.bike.admin.dao.base.TSiteDaoBase;
import com.bike.admin.model.TSiteModel;

/**
 * 这是t_site的Dao实现类
 * @author autoTool 工具生成
 */
public class TSiteDao extends TSiteDaoBase   {
    /**
     * TSiteDao对象
     */
    private static TSiteDao instance = new TSiteDao();

    /**
     * 默认构造方法
     */
    private TSiteDao() {
    }

    /**
     * 获得对象实例
     */
    public static TSiteDao getInstance() { 
         return instance;
    } 

    
    // *************************  手写代码区   ************************************ //
    
    
    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 **************************************
     *                          请把get方法写在下面
     *************************************************************************/
    public List<TSiteModel> findPage2(int start, int length) {
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " order by createTime desc limit ? , ?";
		Object[] paramObjects = {start, length};
		
		return queryModelList(sql, paramObjects);
	} 
	
	@SuppressWarnings("deprecation")
	public int getCount(){
		String sql = "SELECT count(1) FROM " + TABLE ;
		
		CachedRowSet rs = null;
		try {
			rs = readDBEngine.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public int updateStatus(int id, int i) {
		String sql = "UPDATE " + TABLE + " SET sitePosition = ? WHERE ID = ?";
		Object[] paramObjects = {i, id};
		
		try {
			return writeDBEngine.update(sql, paramObjects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
 	}
    
}
