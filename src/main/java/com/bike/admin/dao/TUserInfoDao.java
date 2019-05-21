package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.apache.commons.lang.StringUtils;

import com.bike.admin.dao.base.TUserInfoDaoBase;
import com.bike.admin.model.TUserInfoModel;
import com.bike.admin.util.TimeUtils;

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

	public List<TUserInfoModel> findList(TUserInfoModel model, int start,
			int length, String startCreateTime, String endCreateTime) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT " +ALLCOL + " FROM " + TABLE + " WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (model.getSex() >= 0) {
				sqlBuilder.append(" and sex = ?");
				paramList.add(model.getSex());
			}
			if (StringUtils.isNotEmpty(model.getUserName())) {
				sqlBuilder.append(" and userName = ?");
				paramList.add(model.getUserName());
			}
			if (StringUtils.isNotEmpty(model.getPhoneNum())) {
				sqlBuilder.append(" and phoneNum = ?");
				paramList.add(model.getPhoneNum());
			}
			if (StringUtils.isNotEmpty(model.getIdentityCard())) {
				sqlBuilder.append(" and identityCard = ?");
				paramList.add(model.getIdentityCard());
			}
		}
		
		if (StringUtils.isNotEmpty(startCreateTime) && StringUtils.isNotEmpty(endCreateTime)) {
			sqlBuilder.append(" and createTime between ? and ?");
			Date tempDate = TimeUtils.stringToDate(endCreateTime, "yyyy-MM-dd");
			tempDate = TimeUtils.addDays(tempDate, 1);
			paramList.add(startCreateTime);
			paramList.add(TimeUtils.dateToString(tempDate, "yyyy-MM-dd"));
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
	public int getCount(TUserInfoModel model,
			String startCreateTime, String endCreateTime) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT count(1) FROM " + TABLE + " WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (model.getSex() >= 0) {
				sqlBuilder.append(" and sex = ?");
				paramList.add(model.getSex());
			}
			if (StringUtils.isNotEmpty(model.getUserName())) {
				sqlBuilder.append(" and userName = ?");
				paramList.add(model.getUserName());
			}
			if (StringUtils.isNotEmpty(model.getPhoneNum())) {
				sqlBuilder.append(" and phoneNum = ?");
				paramList.add(model.getPhoneNum());
			}
			if (StringUtils.isNotEmpty(model.getIdentityCard())) {
				sqlBuilder.append(" and identityCard = ?");
				paramList.add(model.getIdentityCard());
			}
		}
		
		if (StringUtils.isNotEmpty(startCreateTime) && StringUtils.isNotEmpty(endCreateTime)) {
			sqlBuilder.append(" and createTime between ? and ?");
			Date tempDate = TimeUtils.stringToDate(endCreateTime, "yyyy-MM-dd");
			tempDate = TimeUtils.addDays(tempDate, 1);
			paramList.add(startCreateTime);
			paramList.add(TimeUtils.dateToString(tempDate, "yyyy-MM-dd"));
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
