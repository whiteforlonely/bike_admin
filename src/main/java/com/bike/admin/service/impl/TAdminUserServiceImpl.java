package com.bike.admin.service.impl;

import java.util.List;

import com.bike.admin.dao.TAdminUserDao;
import com.bike.admin.dto.TAdminUserDTO;
import com.bike.admin.model.TAdminUserModel;
import com.bike.admin.service.TAdminUserService;
import com.systemframework.dto.DtoConvert;
import com.systemframework.util.Page;

/**
 * t_admin_user的接口实现
 * @author autoTool 工具生成
 */
public  class TAdminUserServiceImpl implements  TAdminUserService {

    /**
     * 获得TAdminUserDao的实例
     */
    private static  TAdminUserDao  tAdminUserDao = TAdminUserDao.getInstance();


    /**
     * 保存TAdminUserDTO
     * @param tAdminUserDto TAdminUserDTO对像
     * @return 保存成功后的id
     */
    @Override
    public int saveTAdminUser(TAdminUserDTO  tAdminUserDto){
        if(tAdminUserDto == null ){
             return 0;
        }
        return tAdminUserDao.insert(DtoConvert.convertDto2Model(tAdminUserDto,TAdminUserModel.class));
    }


    /**
     * 修改TAdminUserDTO
     * @param tAdminUserDto TAdminUserDTO对像
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean updateTAdminUser(TAdminUserDTO  tAdminUserDto){
        if(tAdminUserDto == null ){
             return false;
        }
        return tAdminUserDao.update(DtoConvert.convertDto2Model(tAdminUserDto,TAdminUserModel.class));
    }


    /**
     * 根据id进行删除
     * @param id TAdminUser的主键
     * @return 修改成功返回true,失败返回false
     */
    @Override
    public boolean deleteTAdminUserById(int  id){
        if(id <= 0 ){
             return false;
        }
        return tAdminUserDao.deleteByPrimaryKey(id);
    }


    /**
     * 根据主键获得TAdminUser
     * @param id TAdminUser的主键
     * @return 返回TAdminUser对象
     */
    @Override
    public TAdminUserDTO getTAdminUserById(int   id){
        if(id <= 0 ){
             return null;
        }
        return  DtoConvert.convertModel2Dto(tAdminUserDao.findByPrimaryKey( id),TAdminUserDTO.class);
    }


    /**
     * 获得所有的TAdminUserDTO
     * @return TAdminUserDTO集合
     */
    @Override
    public List<TAdminUserDTO> getAllTAdminUser(){
        return  DtoConvert.convertModelList2DtoList(tAdminUserDao.findAll(),TAdminUserDTO.class);
    }


    /**
     * 获得TAdminUserDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TAdminUserDTO分页
     */
    @Override
    public Page<TAdminUserDTO> getTAdminUserPage(int pageSize, int pageNo){
        return  DtoConvert.convertModelPage2DtoPage(tAdminUserDao.findPage(pageSize, pageNo),TAdminUserDTO.class);
    }

    
    
    // *************************  手写代码区   ************************************ //
    @Override
    public TAdminUserDTO getByPhoneAndPwd(String phone, String password) {
    	return DtoConvert.convertModel2Dto(tAdminUserDao.findByPhoneAndPwd(phone, password), TAdminUserDTO.class);
    }
    
    @Override
    public List<TAdminUserDTO> getPage(int start, int length) {
    	return DtoConvert.convertModelList2DtoList(tAdminUserDao.findPage2(start, length), TAdminUserDTO.class);
    }
    
    @Override
    public int getCount() {
    	return tAdminUserDao.getCount();
    }
    
    @Override
    public int updateStatus(int id, int i) {
    	return tAdminUserDao.updateStatus(id, i);
    }
    
    @Override
    public boolean isPhoneExists(String mobilePhone) {
    	return tAdminUserDao.isPhoneExists(mobilePhone);
    }
    
    @Override
    public boolean isPhoneExists(String mobilePhone, int adminUserId) {
    	return tAdminUserDao.isPhoneExists(mobilePhone,adminUserId);
    }


	@Override
	public TAdminUserDTO getUserInfoByPhone(String mobilePhone) {
		return DtoConvert.convertModel2Dto(tAdminUserDao.findByPhone(mobilePhone), TAdminUserDTO.class);
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
