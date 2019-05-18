package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

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
    
    
}