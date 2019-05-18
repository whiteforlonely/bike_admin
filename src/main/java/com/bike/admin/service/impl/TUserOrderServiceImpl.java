package com.bike.admin.service.impl;

import java.util.List;
import com.systemframework.util.Page;
import com.bike.admin.dto.TUserOrderDTO;
import com.bike.admin.model.TUserOrderModel;
import com.bike.admin.dao.TUserOrderDao;
import com.bike.admin.service.TUserOrderService;
import com.systemframework.dto.DtoConvert;

/**
 * t_user_order的接口实现
 * @author autoTool 工具生成
 */
public  class TUserOrderServiceImpl implements  TUserOrderService {

    /**
     * 获得TUserOrderDao的实例
     */
    private static  TUserOrderDao  tUserOrderDao = TUserOrderDao.getInstance();


    /**
     * 保存TUserOrderDTO
     * @param tUserOrderDto TUserOrderDTO对像
     * @return 保存成功后的id
     */
    @Override
    public int saveTUserOrder(TUserOrderDTO  tUserOrderDto){
        if(tUserOrderDto == null ){
             return 0;
        }
        return tUserOrderDao.insert(DtoConvert.convertDto2Model(tUserOrderDto,TUserOrderModel.class));
    }


    /**
     * 修改TUserOrderDTO
     * @param tUserOrderDto TUserOrderDTO对像
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean updateTUserOrder(TUserOrderDTO  tUserOrderDto){
        if(tUserOrderDto == null ){
             return false;
        }
        return tUserOrderDao.update(DtoConvert.convertDto2Model(tUserOrderDto,TUserOrderModel.class));
    }


    /**
     * 根据id进行删除
     * @param id TUserOrder的主键
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean deleteTUserOrderById(int  id){
        if(id <= 0 ){
             return false;
        }
        return tUserOrderDao.deleteByPrimaryKey(id);
    }


    /**
     * 根据主键获得TUserOrder
     * @param id TUserOrder的主键
     * @return 返回TUserOrder对象
     */
    @Override
    public TUserOrderDTO getTUserOrderById(int   id){
        if(id <= 0 ){
             return null;
        }
        return  DtoConvert.convertModel2Dto(tUserOrderDao.findByPrimaryKey( id),TUserOrderDTO.class);
    }


    /**
     * 获得所有的TUserOrderDTO
     * @return TUserOrderDTO集合
     */
    @Override
    public List<TUserOrderDTO> getAllTUserOrder(){
        return  DtoConvert.convertModelList2DtoList(tUserOrderDao.findAll(),TUserOrderDTO.class);
    }


    /**
     * 获得TUserOrderDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TUserOrderDTO分页
     */
    @Override
    public Page<TUserOrderDTO> getTUserOrderPage(int pageSize, int pageNo){
        return  DtoConvert.convertModelPage2DtoPage(tUserOrderDao.findPage(pageSize, pageNo),TUserOrderDTO.class);
    }

    
    
    // *************************  手写代码区   ************************************ //
    
    
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
