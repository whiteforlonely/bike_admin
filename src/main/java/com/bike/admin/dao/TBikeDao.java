package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.apache.commons.lang.StringUtils;

import com.bike.admin.dao.base.TBikeDaoBase;
import com.bike.admin.model.TBikeModel;

/**
 * 这是t_bike的Dao实现类
 * @author autoTool 工具生成
 */
public class TBikeDao extends TBikeDaoBase   {
    /**
     * TBikeDao对象
     */
    private static TBikeDao instance = new TBikeDao();

    /**
     * 默认构造方法
     */
    private TBikeDao() {
    }

    /**
     * 获得对象实例
     */
    public static TBikeDao getInstance() { 
         return instance;
    } 

    
    // *************************  手写代码区   ************************************ //
    public List<TBikeModel> findPage2(int start, int length) {
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " order by createTime desc limit ? , ?";
		Object[] paramObjects = {start, length};
		
		return queryModelList(sql, paramObjects);
	} 
	
	@SuppressWarnings("deprecation")
	public int getCount(){
		String sql = "SELECT count(1) FROM " + TABLE;
		
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
	
	public TBikeModel findByUserId(int userId){
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " where userId = ?";
		
		Object[] paramObjects = {userId};
		
		List<TBikeModel> models = queryModelList(sql, paramObjects);
    	if (null != models && models.size() > 0) {
			return models.get(0);
		}
    	
    	return null;
	}

    
    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 **************************************
     *                          请把get方法写在下面
     *************************************************************************/
	public List<TBikeModel> findList(TBikeModel model, int start, int length) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT " + ALLCOL + " FROM " + TABLE +" WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (null != model.getUserId() && model.getUserId().intValue() > 0) {
				sqlBuilder.append(" and userId = ?");
				paramList.add(model.getUserId());
			}
			if (null != model.getSiteId() && model.getSiteId().intValue() > 0) {
				sqlBuilder.append(" and siteId = ?");
				paramList.add(model.getSiteId());
			}
			if (StringUtils.isNotEmpty(model.getBikeCode())) {
				sqlBuilder.append(" and bikeCode = ?");
				paramList.add(model.getBikeCode());
			}
			if (null != model.getStatus() && model.getStatus().intValue() >= 0) {
				sqlBuilder.append(" and status = ?");
				paramList.add(model.getStatus());
			}
			if (StringUtils.isNotEmpty(model.getColor())) {
				sqlBuilder.append(" and color = ?");
				paramList.add(model.getColor());
			}
		}
		
		sqlBuilder.append(" order by createTime desc limit ?, ?");
		paramList.add(start);
		paramList.add(length);
		
		Object[] paramObjects = new Object[paramList.size()];
		for (int i = 0; i < paramObjects.length; i++) {
			paramObjects[i] = paramList.get(i);
		}
		
		return queryModelList(sqlBuilder.toString(), paramObjects);
	}

	@SuppressWarnings("deprecation")
	public int getCount(TBikeModel model) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT count(1) FROM " + TABLE +" WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (null != model.getUserId() && model.getUserId().intValue() > 0) {
				sqlBuilder.append(" and userId = ?");
				paramList.add(model.getUserId());
			}
			if (null != model.getSiteId() && model.getSiteId().intValue() > 0) {
				sqlBuilder.append(" and siteId = ?");
				paramList.add(model.getSiteId());
			}
			if (StringUtils.isNotEmpty(model.getBikeCode())) {
				sqlBuilder.append(" and bikeCode = ?");
				paramList.add(model.getBikeCode());
			}
			if (null != model.getStatus() && model.getStatus().intValue() >= 0) {
				sqlBuilder.append(" and status = ?");
				paramList.add(model.getStatus());
			}
			if (StringUtils.isNotEmpty(model.getColor())) {
				sqlBuilder.append(" and color = ?");
				paramList.add(model.getColor());
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
