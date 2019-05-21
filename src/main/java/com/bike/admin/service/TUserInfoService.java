package com.bike.admin.service;

import java.util.List;

import com.bike.admin.dto.TUserInfoDTO;
import com.systemframework.util.Page;

/**
 * t_user_info的接口
 * @author autoTool 工具生成
 */
public  interface TUserInfoService  {

    /**
     * 保存TUserInfoDTO
     * @param tUserInfoDto TUserInfoDTO对像
     * @return 保存成功后的id
     */
    public int saveTUserInfo(TUserInfoDTO  tUserInfoDto);


    /**
     * 修改TUserInfoDTO
     * @param tUserInfoDto TUserInfoDTO对像
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateTUserInfo(TUserInfoDTO  tUserInfoDto);


    /**
     * 根据id进行删除
     * @param id TUserInfo的主键
     * @return 修改成功返回true,失败返回false
     */
    public boolean deleteTUserInfoById(int  id);


    /**
     * 根据主键获得TUserInfo
     * @param id TUserInfo的主键
     * @return 返回TUserInfo对象
     */
    public TUserInfoDTO getTUserInfoById(int   id);


    /**
     * 获得所有的TUserInfoDTO
     * @return TUserInfoDTO集合
     */
    public List<TUserInfoDTO> getAllTUserInfo();


    /**
     * 获得TUserInfoDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TUserInfoDTO分页
     */
    public Page<TUserInfoDTO> getTUserInfoPage(int pageSize, int pageNo);

    
    
    // *************************  手写代码区   ************************************ //
    public TUserInfoDTO getByPhoneAndPwd(String phone, String password);
    
    public List<TUserInfoDTO> getPage(int start, int length);

	public int getCount();
	
	public boolean isPhoneExists(String mobilePhone);
	
	public boolean isPhoneExists(String mobilePhone, int adminUserId);


    
    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 *************************************
     *                          请把get方法写在下面
     *************************************************************************/
    
	public List<TUserInfoDTO> getList(TUserInfoDTO dto, int start, int length,
			String startCreateTime, String endCreateTime);


	public int getCount(TUserInfoDTO dto, String startCreateTime,
			String endCreateTime);
    
}
