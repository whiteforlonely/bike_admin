package com.bike.admin.service.impl;

import java.util.List;

import com.bike.admin.dao.TUserInfoDao;
import com.bike.admin.dto.TUserInfoDTO;
import com.bike.admin.model.TUserInfoModel;
import com.bike.admin.service.TUserInfoService;
import com.systemframework.dto.DtoConvert;
import com.systemframework.util.Page;

/**
 * t_user_info的接口实现
 * @author autoTool 工具生成
 */
public  class TUserInfoServiceImpl implements  TUserInfoService {

    /**
     * 获得TUserInfoDao的实例
     */
    private static  TUserInfoDao  tUserInfoDao = TUserInfoDao.getInstance();


    /**
     * 保存TUserInfoDTO
     * @param tUserInfoDto TUserInfoDTO对像
     * @return 保存成功后的id
     */
    @Override
    public int saveTUserInfo(TUserInfoDTO  tUserInfoDto){
        if(tUserInfoDto == null ){
             return 0;
        }
        return tUserInfoDao.insert(DtoConvert.convertDto2Model(tUserInfoDto,TUserInfoModel.class));
    }


    /**
     * 修改TUserInfoDTO
     * @param tUserInfoDto TUserInfoDTO对像
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean updateTUserInfo(TUserInfoDTO  tUserInfoDto){
        if(tUserInfoDto == null ){
             return false;
        }
        return tUserInfoDao.update(DtoConvert.convertDto2Model(tUserInfoDto,TUserInfoModel.class));
    }


    /**
     * 根据id进行删除
     * @param id TUserInfo的主键
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean deleteTUserInfoById(int  id){
        if(id <= 0 ){
             return false;
        }
        return tUserInfoDao.deleteByPrimaryKey(id);
    }


    /**
     * 根据主键获得TUserInfo
     * @param id TUserInfo的主键
     * @return 返回TUserInfo对象
     */
    @Override
    public TUserInfoDTO getTUserInfoById(int   id){
        if(id <= 0 ){
             return null;
        }
        return  DtoConvert.convertModel2Dto(tUserInfoDao.findByPrimaryKey( id),TUserInfoDTO.class);
    }


    /**
     * 获得所有的TUserInfoDTO
     * @return TUserInfoDTO集合
     */
    @Override
    public List<TUserInfoDTO> getAllTUserInfo(){
        return  DtoConvert.convertModelList2DtoList(tUserInfoDao.findAll(),TUserInfoDTO.class);
    }


    /**
     * 获得TUserInfoDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TUserInfoDTO分页
     */
    @Override
    public Page<TUserInfoDTO> getTUserInfoPage(int pageSize, int pageNo){
        return  DtoConvert.convertModelPage2DtoPage(tUserInfoDao.findPage(pageSize, pageNo),TUserInfoDTO.class);
    }

    
    
    // *************************  手写代码区   ************************************ //
    
    @Override
    public TUserInfoDTO getByPhoneAndPwd(String phone, String password) {
    	return DtoConvert.convertModel2Dto(tUserInfoDao.findByPhoneAndPwd(phone, password), TUserInfoDTO.class);
    }
    
    @Override
    public List<TUserInfoDTO> getPage(int start, int length) {
    	return DtoConvert.convertModelList2DtoList(tUserInfoDao.findPage2(start, length), TUserInfoDTO.class);
    }
    
    @Override
    public int getCount() {
    	return tUserInfoDao.getCount();
    }
    
    @Override
    public boolean isPhoneExists(String mobilePhone) {
    	return tUserInfoDao.isPhoneExists(mobilePhone);
    }
    
    @Override
    public boolean isPhoneExists(String mobilePhone, int adminUserId) {
    	return tUserInfoDao.isPhoneExists(mobilePhone,adminUserId);
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
