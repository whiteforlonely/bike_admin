package com.bike.admin.service;

import java.util.List;

import com.bike.admin.dto.TAdminUserDTO;
import com.systemframework.util.Page;

/**
 * t_admin_user的接口
 * @author autoTool 工具生成
 */
public  interface TAdminUserService  {

    /**
     * 保存TAdminUserDTO
     * @param tAdminUserDto TAdminUserDTO对像
     * @return 保存成功后的id
     */
    public int saveTAdminUser(TAdminUserDTO  tAdminUserDto);


    /**
     * 修改TAdminUserDTO
     * @param tAdminUserDto TAdminUserDTO对像
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateTAdminUser(TAdminUserDTO  tAdminUserDto);


    /**
     * 根据id进行删除
     * @param id TAdminUser的主键
     * @return 修改成功返回true,失败返回false
     */
    public boolean deleteTAdminUserById(int  id);


    /**
     * 根据主键获得TAdminUser
     * @param id TAdminUser的主键
     * @return 返回TAdminUser对象
     */
    public TAdminUserDTO getTAdminUserById(int   id);


    /**
     * 获得所有的TAdminUserDTO
     * @return TAdminUserDTO集合
     */
    public List<TAdminUserDTO> getAllTAdminUser();


    /**
     * 获得TAdminUserDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TAdminUserDTO分页
     */
    public Page<TAdminUserDTO> getTAdminUserPage(int pageSize, int pageNo);

    
    
    // *************************  手写代码区   ************************************ //
    public TAdminUserDTO getByPhoneAndPwd(String phone, String password);


	public List<TAdminUserDTO> getPage(int start, int length);


	public int getCount();


	public int updateStatus(int id, int i);


	public boolean isPhoneExists(String mobilePhone);
	
	public boolean isPhoneExists(String mobilePhone, int adminUserId);
	
	public TAdminUserDTO getUserInfoByPhone(String mobilePhone);
    
    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 *************************************
     *                          请把get方法写在下面
     *************************************************************************/
    
    
}
