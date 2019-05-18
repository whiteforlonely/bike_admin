package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.bike.admin.dao.base.TAdminUserDaoBase;
import com.bike.admin.model.TAdminUserModel;

/**
 * 这是t_admin_user的Dao实现类
 * @author autoTool 工具生成
 */
public class TAdminUserDao extends TAdminUserDaoBase   {
    /**
     * TAdminUserDao对象
     */
    private static TAdminUserDao instance = new TAdminUserDao();

    /**
     * 默认构造方法
     */
    private TAdminUserDao() {
    }

    /**
     * 获得对象实例
     */
    public static TAdminUserDao getInstance() { 
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
    	String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE mobilePhone = ? and password = ?";
    	Object[] params = {phone, password};
    	
    	List<TAdminUserModel> models = queryModelList(sql, params);
    	if (null != models && models.size() > 0) {
			return models.get(0);
		}
    	
    	return null;
    }

	public List<TAdminUserModel> findPage2(int start, int length) {
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE status != -100 order by createTime desc limit ? , ?";
		Object[] paramObjects = {start, length};
		
		return queryModelList(sql, paramObjects);
	} 
	
	@SuppressWarnings("deprecation")
	public int getCount(){
		String sql = "SELECT count(1) FROM " + TABLE + " WHERE status != -100";
		
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
		String sql = "UPDATE " + TABLE + " SET status = ? WHERE ID = ?";
		Object[] paramObjects = {i, id};
		
		try {
			return writeDBEngine.update(sql, paramObjects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
 	}

	@SuppressWarnings("deprecation")
	public boolean isPhoneExists(String mobilePhone) {
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE status != -100 AND mobilePhone = ?";
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
		String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE status != -100 AND mobilePhone = ? and id != ?";
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
	
	public Object findByPhone(String phone) {
    	String sql = "SELECT " + ALLCOL + " FROM " + TABLE + " WHERE mobilePhone = ?";
    	Object[] params = {phone};
    	
    	List<TAdminUserModel> models = queryModelList(sql, params);
    	if (null != models && models.size() > 0) {
			return models.get(0);
		}
    	
    	return null;
    }
    
}
