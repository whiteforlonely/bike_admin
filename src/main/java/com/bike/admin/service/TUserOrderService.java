package com.bike.admin.service;

import java.util.List;
import com.systemframework.util.Page;
import com.bike.admin.dto.TUserOrderDTO;

/**
 * t_user_order的接口
 * @author autoTool 工具生成
 */
public  interface TUserOrderService  {

    /**
     * 保存TUserOrderDTO
     * @param tUserOrderDto TUserOrderDTO对像
     * @return 保存成功后的id
     */
    public int saveTUserOrder(TUserOrderDTO  tUserOrderDto);


    /**
     * 修改TUserOrderDTO
     * @param tUserOrderDto TUserOrderDTO对像
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateTUserOrder(TUserOrderDTO  tUserOrderDto);


    /**
     * 根据id进行删除
     * @param id TUserOrder的主键
     * @return 修改成功返回true,失败返回false
     */
    public boolean deleteTUserOrderById(int  id);


    /**
     * 根据主键获得TUserOrder
     * @param id TUserOrder的主键
     * @return 返回TUserOrder对象
     */
    public TUserOrderDTO getTUserOrderById(int   id);


    /**
     * 获得所有的TUserOrderDTO
     * @return TUserOrderDTO集合
     */
    public List<TUserOrderDTO> getAllTUserOrder();


    /**
     * 获得TUserOrderDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TUserOrderDTO分页
     */
    public Page<TUserOrderDTO> getTUserOrderPage(int pageSize, int pageNo);



    
    
    // *************************  手写代码区   ************************************ //
    
    
    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 *************************************
     *                          请把get方法写在下面
     *************************************************************************/
    
    public List<TUserOrderDTO> getList(TUserOrderDTO searchDto, int start,
    		int length, String createTimeStart, String createTimeEnd);


	public int getCount(TUserOrderDTO searchDto, String createTimeStart,
			String createTimeEnd);
    
}
