package com.bike.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.rowset.CachedRowSet;

import org.apache.commons.lang.StringUtils;

import com.bike.admin.dao.base.TUserOrderDaoBase;
import com.bike.admin.model.TUserOrderModel;
import com.bike.admin.util.TimeUtils;

/**
 * 这是t_user_order的Dao实现类
 * @author autoTool 工具生成
 */
public class TUserOrderDao extends TUserOrderDaoBase   {
    /**
     * TUserOrderDao对象
     */
    private static TUserOrderDao instance = new TUserOrderDao();

    /**
     * 默认构造方法
     */
    private TUserOrderDao() {
    }

    /**
     * 获得对象实例
     */
    public static TUserOrderDao getInstance() { 
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
    
    public List<TUserOrderModel> findList(TUserOrderModel model, int start, int length, String startCreateTime, String endCreateTime) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT " + ALLCOL + " FROM " + TABLE +" WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (null != model.getUseId() && model.getUseId().intValue() > 0) {
				sqlBuilder.append(" and useId = ?");
				paramList.add(model.getUseId());
			}
			if (null != model.getIssueId() && model.getIssueId().intValue() > 0) {
				sqlBuilder.append(" and issueId = ?");
				paramList.add(model.getIssueId());
			}
			if (null != model.getBikeId() && model.getBikeId().intValue() > 0) {
				sqlBuilder.append(" and bikeId = ?");
				paramList.add(model.getBikeId());
			}
			if (StringUtils.isNotEmpty(model.getOrderCode())) {
				sqlBuilder.append(" and orderCode = ?");
				paramList.add(model.getOrderCode());
			}
			if (null != model.getOrderType() && model.getOrderType().intValue() >= 0) {
				sqlBuilder.append(" and orderType = ?");
				paramList.add(model.getOrderType());
			}
			if (null != model.getOrderStatus() && model.getOrderStatus().intValue() >= 0) {
				sqlBuilder.append(" and orderStatus = ?");
				paramList.add(model.getOrderStatus());
			}
		}
		
		if (StringUtils.isNotEmpty(startCreateTime) && StringUtils.isNotEmpty(endCreateTime)) {
			sqlBuilder.append(" and createTime between ? and ?");
			Date tempDate = TimeUtils.stringToDate(endCreateTime, "yyyy-MM-dd");
			tempDate = TimeUtils.addDays(tempDate, 1);
			paramList.add(startCreateTime);
			paramList.add(TimeUtils.dateToString(tempDate, "yyyy-MM-dd"));
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
	public int getCount(TUserOrderModel model, String startCreateTime, String endCreateTime) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT count(1) FROM " + TABLE +" WHERE 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if (null != model) {
			if (null != model.getId() && model.getId().intValue() > 0) {
				sqlBuilder.append(" and id = ?");
				paramList.add(model.getId());
			}
			if (null != model.getUseId() && model.getUseId().intValue() > 0) {
				sqlBuilder.append(" and useId = ?");
				paramList.add(model.getUseId());
			}
			if (null != model.getIssueId() && model.getIssueId().intValue() > 0) {
				sqlBuilder.append(" and issueId = ?");
				paramList.add(model.getIssueId());
			}
			if (null != model.getBikeId() && model.getBikeId().intValue() > 0) {
				sqlBuilder.append(" and bikeId = ?");
				paramList.add(model.getBikeId());
			}
			if (StringUtils.isNotEmpty(model.getOrderCode())) {
				sqlBuilder.append(" and orderCode = ?");
				paramList.add(model.getOrderCode());
			}
			if (null != model.getOrderType() && model.getOrderType().intValue() >= 0) {
				sqlBuilder.append(" and orderType = ?");
				paramList.add(model.getOrderType());
			}
			if (null != model.getOrderStatus() && model.getOrderStatus().intValue() >= 0) {
				sqlBuilder.append(" and orderStatus = ?");
				paramList.add(model.getOrderStatus());
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

	@SuppressWarnings("deprecation")
	public Map<Integer, Integer> getOrderIdsByBikeIds(Set<Integer> bikeIds) {
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		String sql = "select id, bikeId from "+TABLE+" where bikeId in ("+StringUtils.join(bikeIds, ',')+")";
		
		CachedRowSet rs =null;
		try {
			rs = readDBEngine.executeQuery(sql);
			while (rs.next()) {
				resultMap.put(rs.getInt(2), rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultMap;
	}
}
