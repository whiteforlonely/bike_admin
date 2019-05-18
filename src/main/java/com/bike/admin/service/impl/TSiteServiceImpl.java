package com.bike.admin.service.impl;

import java.util.List;

import com.bike.admin.dao.TSiteDao;
import com.bike.admin.dto.TSiteDTO;
import com.bike.admin.model.TSiteModel;
import com.bike.admin.service.TSiteService;
import com.systemframework.dto.DtoConvert;
import com.systemframework.util.Page;

/**
 * t_site的接口实现
 * @author autoTool 工具生成
 */
public  class TSiteServiceImpl implements  TSiteService {

    /**
     * 获得TSiteDao的实例
     */
    private static  TSiteDao  tSiteDao = TSiteDao.getInstance();


    /**
     * 保存TSiteDTO
     * @param tSiteDto TSiteDTO对像
     * @return 保存成功后的id
     */
    @Override
    public int saveTSite(TSiteDTO  tSiteDto){
        if(tSiteDto == null ){
             return 0;
        }
        return tSiteDao.insert(DtoConvert.convertDto2Model(tSiteDto,TSiteModel.class));
    }


    /**
     * 修改TSiteDTO
     * @param tSiteDto TSiteDTO对像
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean updateTSite(TSiteDTO  tSiteDto){
        if(tSiteDto == null ){
             return false;
        }
        return tSiteDao.update(DtoConvert.convertDto2Model(tSiteDto,TSiteModel.class));
    }


    /**
     * 根据id进行删除
     * @param id TSite的主键
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean deleteTSiteById(int  id){
        if(id <= 0 ){
             return false;
        }
        return tSiteDao.deleteByPrimaryKey(id);
    }


    /**
     * 根据主键获得TSite
     * @param id TSite的主键
     * @return 返回TSite对象
     */
    @Override
    public TSiteDTO getTSiteById(int   id){
        if(id <= 0 ){
             return null;
        }
        return  DtoConvert.convertModel2Dto(tSiteDao.findByPrimaryKey( id),TSiteDTO.class);
    }


    /**
     * 获得所有的TSiteDTO
     * @return TSiteDTO集合
     */
    @Override
    public List<TSiteDTO> getAllTSite(){
        return  DtoConvert.convertModelList2DtoList(tSiteDao.findAll(),TSiteDTO.class);
    }


    /**
     * 获得TSiteDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TSiteDTO分页
     */
    @Override
    public Page<TSiteDTO> getTSitePage(int pageSize, int pageNo){
        return  DtoConvert.convertModelPage2DtoPage(tSiteDao.findPage(pageSize, pageNo),TSiteDTO.class);
    }

    
    
    // *************************  手写代码区   ************************************ //
    @Override
    public List<TSiteDTO> getPage(int start, int length) {
    	return DtoConvert.convertModelList2DtoList(tSiteDao.findPage2(start, length), TSiteDTO.class);
    }
    
    @Override
    public int getCount() {
    	return tSiteDao.getCount();
    }
    
    @Override
    public int updateStatus(int id, int i) {
    	return tSiteDao.updateStatus(id, i);
    }
    
    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 ***********************************
     *                          请把get方法写在下面
     *************************************************************************/
    
    
}
