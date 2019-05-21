package com.bike.admin.service.impl;

import java.util.List;

import com.bike.admin.dao.TBikeDao;
import com.bike.admin.dto.TBikeDTO;
import com.bike.admin.model.TBikeModel;
import com.bike.admin.service.TBikeService;
import com.systemframework.dto.DtoConvert;
import com.systemframework.util.Page;

/**
 * t_bike的接口实现
 * @author autoTool 工具生成
 */
public  class TBikeServiceImpl implements  TBikeService {

    /**
     * 获得TBikeDao的实例
     */
    private static  TBikeDao  tBikeDao = TBikeDao.getInstance();


    /**
     * 保存TBikeDTO
     * @param tBikeDto TBikeDTO对像
     * @return 保存成功后的id
     */
    @Override
    public int saveTBike(TBikeDTO  tBikeDto){
        if(tBikeDto == null ){
             return 0;
        }
        return tBikeDao.insert(DtoConvert.convertDto2Model(tBikeDto,TBikeModel.class));
    }


    /**
     * 修改TBikeDTO
     * @param tBikeDto TBikeDTO对像
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean updateTBike(TBikeDTO  tBikeDto){
        if(tBikeDto == null ){
             return false;
        }
        return tBikeDao.update(DtoConvert.convertDto2Model(tBikeDto,TBikeModel.class));
    }


    /**
     * 根据id进行删除
     * @param id TBike的主键
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean deleteTBikeById(int  id){
        if(id <= 0 ){
             return false;
        }
        return tBikeDao.deleteByPrimaryKey(id);
    }


    /**
     * 根据主键获得TBike
     * @param id TBike的主键
     * @return 返回TBike对象
     */
    @Override
    public TBikeDTO getTBikeById(int   id){
        if(id <= 0 ){
             return null;
        }
        return  DtoConvert.convertModel2Dto(tBikeDao.findByPrimaryKey( id),TBikeDTO.class);
    }


    /**
     * 获得所有的TBikeDTO
     * @return TBikeDTO集合
     */
    @Override
    public List<TBikeDTO> getAllTBike(){
        return  DtoConvert.convertModelList2DtoList(tBikeDao.findAll(),TBikeDTO.class);
    }


    /**
     * 获得TBikeDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TBikeDTO分页
     */
    @Override
    public Page<TBikeDTO> getTBikePage(int pageSize, int pageNo){
        return  DtoConvert.convertModelPage2DtoPage(tBikeDao.findPage(pageSize, pageNo),TBikeDTO.class);
    }

    
    
    // *************************  手写代码区   ************************************ //
    @Override
    public List<TBikeDTO> getPage(int start, int length) {
    	return DtoConvert.convertModelList2DtoList(tBikeDao.findPage2(start, length), TBikeDTO.class);
    }
    
    @Override
    public int getCount() {
    	return tBikeDao.getCount();
    }


	@Override
	public TBikeDTO getBikeByUserId(int userId) {
		return DtoConvert.convertModel2Dto(tBikeDao.findByUserId(userId), TBikeDTO.class);
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
    
    @Override
    public List<TBikeDTO> getList(TBikeDTO dto, int start, int length) {
    	return DtoConvert.convertModelList2DtoList(tBikeDao.findList(DtoConvert.convertDto2Model(dto, TBikeModel.class), start, length), TBikeDTO.class); 
    }
    
    @Override
    public int getCount(TBikeDTO dto) {
    	return tBikeDao.getCount(DtoConvert.convertDto2Model(dto, TBikeModel.class));
    }
}
