package com.bike.admin.dao.base;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.CachedRowSet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bike.admin.model.TAdminUserModel;
import com.constants.DatabaseConstants;
import com.systemframework.dao.HqlQueryRule;
import com.systemframework.util.Page;
import com.systemframework.util.PageUtil;
import com.xstardl.xf.xchine_dbo_mysql.xsql.DBEngine;
import com.xstardl.xf.xchine_dbo_mysql.xsql.DBFactory;

/**
 * 这是t_admin_user的Dao实现类的基类
 */
public  abstract class TAdminUserDaoBase {

    /**
     * 日志处理类实例
     */
    protected static Log logger = LogFactory.getLog(TAdminUserDaoBase.class);
    /**
     * 只读DB引擎
     */
    protected DBEngine readDBEngine = DBFactory.getDBEngine(DatabaseConstants.MAIN_DB_R);
    /**
     * 只写DB引擎
     */
    protected DBEngine writeDBEngine = DBFactory.getDBEngine(DatabaseConstants.MAIN_DB_RW); 
    /**
     * t_admin_user表
     */
    protected static final String TABLE = "t_admin_user";
    
    /**
     * 所有的字段,','隔开 
     */
    protected static final String ALLCOL = " Id,Nickname,Mobilephone,Password,UserType,Auths,CreateTime,Status ";

    protected static final String BASE_SQL = " SELECT " + ALLCOL + " FROM " + TABLE + " ";



    /**
     *  由数据库查询结果集获得Model
     *  @param rs 数据库查询结果集
     */
    protected TAdminUserModel getModelByResultSet(ResultSet rs){
        if(rs == null ) { 
           return null;  
         } 
         TAdminUserModel    model =  new TAdminUserModel(); 
           try{
				ResultSetMetaData metaData = rs.getMetaData();
				if(metaData.getColumnCount() > 0){
					for(int i = 1 ; i <= metaData.getColumnCount() ; i ++){
						String columnName = metaData.getColumnName(i);
						if(StringUtils.equalsIgnoreCase("id",columnName)){
							model.setId(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("nickname",columnName)){
               				model.setNickname(rs.getString(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("mobilephone",columnName)){
               				model.setMobilephone(rs.getString(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("password",columnName)){
               				model.setPassword(rs.getString(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("userType",columnName)){
							model.setUserType(rs.getInt(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("auths",columnName)){
               				model.setAuths(rs.getString(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("createTime",columnName)){
               				model.setCreateTime(rs.getDate(columnName));
						}
						else if(StringUtils.equalsIgnoreCase("status",columnName)){
							model.setStatus(rs.getInt(columnName));
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
     * @param  model TAdminUserModel对象
     * @return 返回插入影响行数
     */
    public int insert(TAdminUserModel model) {
        DBEngine localEngine = DBFactory.getKeepConnectionDBEngine(DatabaseConstants.MAIN_DB_RW);
        String sql = "INSERT INTO " + TABLE + " (Nickname,Mobilephone,Password,UserType,Auths,CreateTime,Status) VALUES (?,?,?,?,?,?,?)";
        Object[]  paramObj = {model.getNickname(),model.getMobilephone(),model.getPassword(),model.getUserType(),model.getAuths(),model.getCreateTime(),model.getStatus()};
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
     * @param  model TAdminUserModel对象
     * @return 修改成功返回true,否则返回false
     */
    public boolean update(TAdminUserModel model) {
        String sql = "UPDATE  " + TABLE + " SET Nickname = ? ,Mobilephone = ? ,Password = ? ,UserType = ? ,Auths = ? ,CreateTime = ? ,Status = ?  WHERE Id = ? ";
        Object[]  paramObj = {model.getNickname(),model.getMobilephone(),model.getPassword(),model.getUserType(),model.getAuths(),model.getCreateTime(),model.getStatus(),model.getId()};
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
    protected TAdminUserModel queryModelByHql(HqlQueryRule queryRule) {
         List<TAdminUserModel> list =   this.queryModelList(this.getFullSqlByHql(queryRule), queryRule.getValues()); 
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
    protected List<TAdminUserModel> queryModelListByHql(HqlQueryRule queryRule) {
        return  this.queryModelList(this.getFullSqlByHql(queryRule), queryRule.getValues());
     }
     
    /**
     * 获得model集合
     * @param  sql  查询语句
     * @return 返回Model集合
     */
    protected List<TAdminUserModel> queryModelList(String sql) {
        List<TAdminUserModel > modelList = new ArrayList<TAdminUserModel>();
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
    protected List<TAdminUserModel> queryModelList(String sql, Object[] paramObjs) {
        List<TAdminUserModel > modelList = new ArrayList<TAdminUserModel>();
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
    public TAdminUserModel findByPrimaryKey(Integer id) {
       HqlQueryRule queryRule = HqlQueryRule.getInstance();
       queryRule.addEqual("id",id);
       
       return this.queryModelByHql(queryRule);
   }

    /**
     * 获得model集合
     * @return 返回Model集合
     */
    public List<TAdminUserModel> findAll() {
        return this.queryModelListByHql(null);
    }

    /**
     * 根据查询规则获页码分页
     * @param queryRule 查询规则
     * @param pageSize 分页大小
     * @param pageNo 页码
     * @return 返回分页对象
     */
    protected Page<TAdminUserModel> findPageByHql(HqlQueryRule queryRule,  int pageSize, int pageNo) {
        return this.findPage(this.getFullSqlByHql(queryRule), queryRule.getValues(), pageSize, pageNo); 
    }
    /**
     * 获分页
     * @param sql 查询条件
     * @param pageSize 分页大小
     * @param pageNo 页码
     * @return 返回分页对象
     */
    protected Page<TAdminUserModel> findPage(String sql, Object[] paramObjs, int pageSize, int pageNo) {
        CachedRowSet rs = null; 
        Page<TAdminUserModel> resultPage = null;
        try{
           sql += PageUtil.getSQLLimitByPageIdAndPageSize(pageNo, pageSize);
           rs = this.readDBEngine.executeQuery(sql,paramObjs);
           List<TAdminUserModel> list = new ArrayList<TAdminUserModel>();
            while( rs.next()) {
               list.add(this.getModelByResultSet(rs));
            }
           if (list.size() > 0) {
              resultPage = new Page<TAdminUserModel>(list,pageSize, pageNo);
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
    protected Page<TAdminUserModel> findPage(String sql, int pageSize, int pageNo) {
        CachedRowSet rs = null; 
        Page<TAdminUserModel> resultPage = null;
        try{
           sql += PageUtil.getSQLLimitByPageIdAndPageSize(pageNo, pageSize);
           rs = this.readDBEngine.executeQuery(sql);
           List<TAdminUserModel> list = new ArrayList<TAdminUserModel>();
            while( rs.next()) {
               list.add(this.getModelByResultSet(rs));
            }
           if (list.size() > 0) {
              resultPage = new Page<TAdminUserModel>(list,pageSize, pageNo);
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
    public Page<TAdminUserModel> findPage(int pageSize, int pageNo) {
        return this.findPageByHql(null, pageSize, pageNo);
    }

    /**
     * 获得Map<id,TAdminUserModel>
     * @param  idList  主键id集
     * @return 返回Map<id,TAdminUserModel>
     */
    public  Map<Integer,TAdminUserModel> findModelMapByIdList(List<Integer> idList) {
       if(idList == null || idList.size() == 0 ){
           return null;
        }
        
        HqlQueryRule queryRule = HqlQueryRule.getInstance(); 
        queryRule.addIn("id", idList) ; 
        return this.findModelMapByHql(queryRule);
     }
    /**
     * 获得Map<id,TAdminUserModel>
     * @param  HqlQueryRule  queryRule
     * @return 返回Map<id,TAdminUserModel>
     */
    protected  Map<Integer,TAdminUserModel> findModelMapByHql(HqlQueryRule queryRule) {
        Map<Integer,TAdminUserModel>  resultModelMap = new HashMap<Integer,TAdminUserModel>();
        
        try {
             ResultSet rs = readDBEngine.executeQuery(this.getFullSqlByHql(queryRule), queryRule.getValues());
             while( rs.next()) {
                  TAdminUserModel model =  this.getModelByResultSet(rs);
                   resultModelMap.put(model.getId(), model); 
             }
        } catch(Exception e) {
           e.printStackTrace();
        }
        return resultModelMap;
     }
}
