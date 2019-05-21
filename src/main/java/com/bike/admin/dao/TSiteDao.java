package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.apache.commons.lang.StringUtils;

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

	public List<TSiteModel> findList(TSiteModel model, int start, int length) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT " + ALLCOL + " FROM " + TABLE + " WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (null != model.getUserId() && model.getUserId().intValue()>0){
				sqlBuilder.append(" and userId = ?");
				paramList.add(model.getUserId());
			}
			if (StringUtils.isNotEmpty(model.getName())) {
				sqlBuilder.append(" and name like ?");
				paramList.add("%" + model.getName() + "%");
			}
		}
		
		sqlBuilder.append(" order by id desc limit ?, ?");
		paramList.add(start);
		paramList.add(length);
		
		Object[] paramObjects = new Object[paramList.size()];
		for (int i = 0; i < paramObjects.length; i++) {
			paramObjects[i] = paramList.get(i);
		}
		
		return queryModelList(sqlBuilder.toString(), paramObjects);
	}

	@SuppressWarnings("deprecation")
	public int getCount(TSiteModel model) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT count(1) FROM " + TABLE + " WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (null != model.getUserId() && model.getUserId().intValue()>0){
				sqlBuilder.append(" and userId = ?");
				paramList.add(model.getUserId());
			}
			if (StringUtils.isNotEmpty(model.getName())) {
				sqlBuilder.append(" and name like ?");
				paramList.add("%" + model.getName() + "%");
			}
		}
		
		Object[] paramObjects = new Object[paramList.size()];
		for (int i = 0; i < paramObjects.length; i++) {
			paramObjects[i] = paramList.get(i);
		}
		
		CachedRowSet rs = null;
		try {
			rs = writeDBEngine.executeQuery(sqlBuilder.toString(), paramObjects);
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
    
}
