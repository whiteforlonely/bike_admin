package com.bike.admin.dao.base;

import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import com.xstardl.xf.xchine_dbo_mysql.xsql.DBEngine;
import com.xstardl.xf.xchine_dbo_mysql.xsql.DBFactory;
import com.systemframework.util.Page;
import com.systemframework.util.PageUtil;
import com.systemframework.dao.HqlQueryRule;
import  javax.sql.rowset.CachedRowSet;
import  org.apache.commons.lang.StringUtils;
import  com.constants.DatabaseConstants;
import com.bike.admin.model.TUserOrderModel;

/**
 * 这是t_user_order的Dao实现类的基类
 */
public  abstract class TUserOrderDaoBase {

    /**
     * 日志处理类实例
     */
    protected static Log logger = LogFactory.getLog(TUserOrderDaoBase.class);
    /**
     * 只读DB引擎
     */
    protected DBEngine readDBEngine = DBFactory.getDBEngine(DatabaseConstants.MAIN_DB_R);
    /**
     * 只写DB引擎
     */
    protected DBEngine writeDBEngine = DBFactory.getDBEngine(DatabaseConstants.MAIN_DB_RW); 
    /**
     * t_user_order表
     */
    protected static final String TABLE = "t_user_order";
    
    /**
     * 所有的字段,','隔开 
     */
    protected static final String ALLCOL = " Id,UseId,IssueId,BikeId,OrderCode,BetAmount,OrderStatus,CreateTime ";

    protected static final String BASE_SQL = " SELECT " + ALLCOL + " FROM " + TABLE + " ";



    /**
     *  由数据库查询结果集获得Model
     *  @param rs 数据库查询结果集
     */
    protected TUserOrderModel getModelByResultSet(ResultSet rs){
        if(rs == null ) { 
           return null;  
         } 
         TUserOrderModel    model =  new TUserOrderModel(); 
           try{
				ResultSetMetaData metaData = rs.getMetaData();
				if(metaData.getColumnCount() > 0){
					for(int i = 1 ; i <= metaData.getColumnCount() ; i ++){
						String columnName = metaData.getColumnName(i);
						if(StringUtils.equalsIgnoreCase("id",columnName)){
							model.setId(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("useId",columnName)){
							model.setUseId(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("issueId",columnName)){
							model.setIssueId(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("bikeId",columnName)){
							model.setBikeId(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("orderCode",columnName)){
               				model.setOrderCode(rs.getString(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("betAmount",columnName)){
               				model.setBetAmount(rs.getDouble(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("orderStatus",columnName)){
							model.setOrderStatus(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("createTime",columnName)){
               				model.setCreateTime(rs.getDate(columnName));
						}
					}
				}
           }catch(Exception e) {
              e.printStackTrace(); 
           }
           return model; 
    }

    /**
     * 插入一条数据
     * @param  model TUserOrderModel对象
     * @return 返回插入影响行数
     */
    public int insert(TUserOrderModel model) {
        DBEngine localEngine = DBFactory.getKeepConnectionDBEngine(DatabaseConstants.MAIN_DB_RW);
        String sql = "INSERT INTO " + TABLE + " (UseId,IssueId,BikeId,OrderCode,BetAmount,OrderStatus,CreateTime) VALUES (?,?,?,?,?,?,?)";
        Object[]  paramObj = {model.getUseId(),model.getIssueId(),model.getBikeId(),model.getOrderCode(),model.getBetAmount(),model.getOrderStatus(),model.getCreateTime()};
        int id=0;
        try {
             id = localEngine.executeUpdate(sql, paramObj);
             ResultSet rs = localEngine.executeQuery("select last_insert_id() as id");
             if (rs.next()) {
               id = rs.getInt("id");
             }
        } catch(Exception e) {
           e.printStackTrace();
        } finally {
           localEngine.close();
        }
        return id;
    }

    /**
     * 修改一条数据
     * @param  model TUserOrderModel对象
     * @return 修改成功返回true,否则返回false
     */
    public boolean update(TUserOrderModel model) {
        String sql = "UPDATE  " + TABLE + " SET UseId = ? ,IssueId = ? ,BikeId = ? ,OrderCode = ? ,BetAmount = ? ,OrderStatus = ? ,CreateTime = ?  WHERE Id = ? ";
        Object[]  paramObj = {model.getUseId(),model.getIssueId(),model.getBikeId(),model.getOrderCode(),model.getBetAmount(),model.getOrderStatus(),model.getCreateTime(),model.getId()};
        try {
             return writeDBEngine.executeUpdate(sql, paramObj)>0;
        } catch(Exception e) {
           e.printStackTrace();
        }
        return false;
     }

    /**
     * 按主键删除一条数据
     * @param id id
     * @return 删除成功返回true,否则返回false
     */
    public boolean deleteByPrimaryKey(Integer id) {
       HqlQueryRule queryRule = HqlQueryRule.getInstance();
       queryRule.addEqual("id",id);

       int count = this.deleteByHql(queryRule); 
       if(count > 0 ){
          return true;
       }
       return false;
 }
    /**
     * 根据QueryRule删除内容 
     * @param queryRule 查询条件
     * @return 影响次数
     */
    protected int deleteByHql(HqlQueryRule queryRule) {
        if(queryRule == null){
           return 0;
        }
        String sql = "DELETE FROM " + TABLE + " WHERE " + queryRule.getHql();

       try{
           return writeDBEngine.executeUpdate(sql, queryRule.getValues()); 
       } catch (Exception e) {
            e.printStackTrace();
       }
       return 0;
 }

    /**
     * 由HqlQueryRule获得完成的sql
     * @param  queryRule queryRule {@link com.systemframework.dao.HqlQueryRule} 查询对象
     * @return 完整sql
     */
    protected String getFullSqlByHql(HqlQueryRule queryRule){
        String sql = BASE_SQL; 
        if(queryRule != null && StringUtils.isNotBlank(queryRule.getHql())){
          sql +=  " where " + queryRule.getHql(); 
        }
        return sql;
     }

    /**
     * 根据HqlQueryRule获得model集合
     * @param  queryRule {@link com.systemframework.dao.HqlQueryRule} 查询对象
     * @return 返回Model集合
     */
    protected TUserOrderModel queryModelByHql(HqlQueryRule queryRule) {
         List<TUserOrderModel> list =   this.queryModelList(this.getFullSqlByHql(queryRule), queryRule.getValues()); 
         if(list != null && list.size() > 0 ) {
               return list.get(0); 
         } else {
            return null; 
         }
     }
     
    /**
     * 根据HqlQueryRule获得model集合
     * @param  queryRule {@link com.systemframework.dao.HqlQueryRule} 查询对象
     * @return 返回Model集合
     */
    protected List<TUserOrderModel> queryModelListByHql(HqlQueryRule queryRule) {
        return  this.queryModelList(this.getFullSqlByHql(queryRule), queryRule.getValues());
     }
     
    /**
     * 获得model集合
     * @param  sql  查询语句
     * @return 返回Model集合
     */
    protected List<TUserOrderModel> queryModelList(String sql) {
        List<TUserOrderModel > modelList = new ArrayList<TUserOrderModel>();
        try {
             ResultSet rs = readDBEngine.executeQuery(sql);
             while( rs.next()) {
                  modelList.add(this.getModelByResultSet(rs));
             }
        } catch(Exception e) {
           e.printStackTrace();
        }
        return modelList;
     }
    
    /**
     * 获得model集合
     * @param  sql   查询语句
     * @param  paramObjs  参数集
     * @return 返回Model集合
     */
    protected List<TUserOrderModel> queryModelList(String sql, Object[] paramObjs) {
        List<TUserOrderModel > modelList = new ArrayList<TUserOrderModel>();
        try {
             ResultSet rs = readDBEngine.executeQuery(sql, paramObjs);
             while( rs.next()) {
                  modelList.add(this.getModelByResultSet(rs));
             }
        } catch(Exception e) {
           e.printStackTrace();
        }
        return modelList;
     }

    /**
     * 按主键查询model
     * @param id id
     * @return model
     */
    public TUserOrderModel findByPrimaryKey(Integer id) {
       HqlQueryRule queryRule = HqlQueryRule.getInstance();
       queryRule.addEqual("id",id);
       
       return this.queryModelByHql(queryRule);
   }

    /**
     * 获得model集合
     * @return 返回Model集合
     */
    public List<TUserOrderModel> findAll() {
        return this.queryModelListByHql(null);
    }

    /**
     * 根据查询规则获页码分页
     * @param queryRule 查询规则
     * @param pageSize 分页大小
     * @param pageNo 页码
     * @return 返回分页对象
     */
    protected Page<TUserOrderModel> findPageByHql(HqlQueryRule queryRule,  int pageSize, int pageNo) {
        return this.findPage(this.getFullSqlByHql(queryRule), queryRule.getValues(), pageSize, pageNo); 
    }
    /**
     * 获分页
     * @param sql 查询条件
     * @param pageSize 分页大小
     * @param pageNo 页码
     * @return 返回分页对象
     */
    protected Page<TUserOrderModel> findPage(String sql, Object[] paramObjs, int pageSize, int pageNo) {
        CachedRowSet rs = null; 
        Page<TUserOrderModel> resultPage = null;
        try{
           sql += PageUtil.getSQLLimitByPageIdAndPageSize(pageNo, pageSize);
           rs = this.readDBEngine.executeQuery(sql,paramObjs);
           List<TUserOrderModel> list = new ArrayList<TUserOrderModel>();
            while( rs.next()) {
               list.add(this.getModelByResultSet(rs));
            }
           if (list.size() > 0) {
              resultPage = new Page<TUserOrderModel>(list,pageSize, pageNo);
           }
        } catch(Exception e) {
             e.printStackTrace();
        }
        return resultPage;
    }
    
    /**
     * 获分页
     * @param sql 查询条件
     * @param pageSize 分页大小
     * @param pageNo 页码
     * @return 返回分页对象
     */
    protected Page<TUserOrderModel> findPage(String sql, int pageSize, int pageNo) {
        CachedRowSet rs = null; 
        Page<TUserOrderModel> resultPage = null;
        try{
           sql += PageUtil.getSQLLimitByPageIdAndPageSize(pageNo, pageSize);
           rs = this.readDBEngine.executeQuery(sql);
           List<TUserOrderModel> list = new ArrayList<TUserOrderModel>();
            while( rs.next()) {
               list.add(this.getModelByResultSet(rs));
            }
           if (list.size() > 0) {
              resultPage = new Page<TUserOrderModel>(list,pageSize, pageNo);
           }
        } catch(Exception e) {
             e.printStackTrace();
        }
        return resultPage;
    }

    /**
     * 获分页
     * @param pageSize 分页大小
     * @param pageNo 页码
     * @return 返回分页对象
     */
    public Page<TUserOrderModel> findPage(int pageSize, int pageNo) {
        return this.findPageByHql(null, pageSize, pageNo);
    }

    /**
     * 获得Map<id,TUserOrderModel>
     * @param  idList  主键id集
     * @return 返回Map<id,TUserOrderModel>
     */
    public  Map<Integer,TUserOrderModel> findModelMapByIdList(List<Integer> idList) {
       if(idList == null || idList.size() == 0 ){
           return null;
        }
        
        HqlQueryRule queryRule = HqlQueryRule.getInstance(); 
        queryRule.addIn("id", idList) ; 
        return this.findModelMapByHql(queryRule);
     }
    /**
     * 获得Map<id,TUserOrderModel>
     * @param  HqlQueryRule  queryRule
     * @return 返回Map<id,TUserOrderModel>
     */
    protected  Map<Integer,TUserOrderModel> findModelMapByHql(HqlQueryRule queryRule) {
        Map<Integer,TUserOrderModel>  resultModelMap = new HashMap<Integer,TUserOrderModel>();
        
        try {
             ResultSet rs = readDBEngine.executeQuery(this.getFullSqlByHql(queryRule), queryRule.getValues());
             while( rs.next()) {
                  TUserOrderModel model =  this.getModelByResultSet(rs);
                   resultModelMap.put(model.getId(), model); 
             }
        } catch(Exception e) {
           e.printStackTrace();
        }
        return resultModelMap;
     }
}
