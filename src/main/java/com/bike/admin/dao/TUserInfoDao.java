package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.bike.admin.dao.base.TUserInfoDaoBase;
import com.bike.admin.model.TUserInfoModel;

/**
 * 这是t_user_info的Dao实现类
 * @author autoTool 工具生成
 */
public class TUserInfoDao extends TUserInfoDaoBase   {
    /**
     * TUserInfoDao对象
     */
    private static TUserInfoDao instance = new TUserInfoDao();

    /**
     * 默认构造方法
     */
    private TUserInfoDao() {
    }

    /**
     * 获得对象实例
     */
    public static TUserInfoDao getInstance() { 
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
    public Object findByPhoneAndPwd(String phone, String password) {
    	String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE phoneNum = ? and password = ?";
    	Object[] params = {phone, password};
    	
    	List<TUserInfoModel> models = queryModelList(sql, params);
    	if (null != models && models.size() > 0) {
			return models.get(0);
		}
    	
    	return null;
    }

	public List<TUserInfoModel> findPage2(int start, int length) {
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

	@SuppressWarnings("deprecation")
	public boolean isPhoneExists(String mobilePhone) {
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " where phoneNum = ?";
		Object[] params = {mobilePhone};
		
		CachedRowSet rs = null;
		try {
			rs = readDBEngine.executeQuery(sql, params);
			return rs.next();
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
		
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public boolean isPhoneExists(String mobilePhone, int id) {
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE phoneNum = ? and id != ?";
		Object[] params = {mobilePhone, id};
		
		CachedRowSet rs = null;
		try {
			rs = readDBEngine.executeQuery(sql, params);
			return rs.next();
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
		
		
		return false;
	}
    
    
}
