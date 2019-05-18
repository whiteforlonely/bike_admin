package com.bike.admin.service;

import java.util.List;

import com.bike.admin.dto.TBikeDTO;
import com.systemframework.util.Page;

/**
 * t_bike的接口
 * @author autoTool 工具生成
 */
public  interface TBikeService  {

    /**
     * 保存TBikeDTO
     * @param tBikeDto TBikeDTO对像
     * @return 保存成功后的id
     */
    public int saveTBike(TBikeDTO  tBikeDto);


    /**
     * 修改TBikeDTO
     * @param tBikeDto TBikeDTO对像
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateTBike(TBikeDTO  tBikeDto);


    /**
     * 根据id进行删除
     * @param id TBike的主键
     * @return 修改成功返回true,失败返回false
     */
    public boolean deleteTBikeById(int  id);


    /**
     * 根据主键获得TBike
     * @param id TBike的主键
     * @return 返回TBike对象
     */
    public TBikeDTO getTBikeById(int   id);


    /**
     * 获得所有的TBikeDTO
     * @return TBikeDTO集合
     */
    public List<TBikeDTO> getAllTBike();


    /**
     * 获得TBikeDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TBikeDTO分页
     */
    public Page<TBikeDTO> getTBikePage(int pageSize, int pageNo);

    
    
    // *************************  手写代码区   ************************************ //
    
	public List<TBikeDTO> getPage(int start, int length);
	
	public int getCount();
	
	public TBikeDTO getBikeByUserId(int userId);
    
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
