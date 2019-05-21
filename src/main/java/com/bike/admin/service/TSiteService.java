package com.bike.admin.service;

import java.util.List;

import com.bike.admin.dto.TSiteDTO;
import com.systemframework.util.Page;

/**
 * t_site的接口
 * @author autoTool 工具生成
 */
public  interface TSiteService  {

    /**
     * 保存TSiteDTO
     * @param tSiteDto TSiteDTO对像
     * @return 保存成功后的id
     */
    public int saveTSite(TSiteDTO  tSiteDto);


    /**
     * 修改TSiteDTO
     * @param tSiteDto TSiteDTO对像
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateTSite(TSiteDTO  tSiteDto);


    /**
     * 根据id进行删除
     * @param id TSite的主键
     * @return 修改成功返回true,失败返回false
     */
    public boolean deleteTSiteById(int  id);


    /**
     * 根据主键获得TSite
     * @param id TSite的主键
     * @return 返回TSite对象
     */
    public TSiteDTO getTSiteById(int   id);


    /**
     * 获得所有的TSiteDTO
     * @return TSiteDTO集合
     */
    public List<TSiteDTO> getAllTSite();


    /**
     * 获得TSiteDTO的分页
     * @param pageSize 页面大小
     * @param pagNo 页码
     * @return TSiteDTO分页
     */
    public Page<TSiteDTO> getTSitePage(int pageSize, int pageNo);

    
    
    // *************************  手写代码区   ************************************ //

   	public List<TSiteDTO> getPage(int start, int length);


   	public int getCount();


   	public int updateStatus(int id, int i);


    /*************************** update方法 ***********************************
     *                          请把update方法写在下面
     *************************************************************************/
    
    
    /*************************** delete方法 ***********************************
     *                          请把delete方法写在下面
     *************************************************************************/
    
    
    /*************************** get方法 *************************************
     *                          请把get方法写在下面
     *************************************************************************/
    
   	public List<TSiteDTO> getList(TSiteDTO dto, int start, int length);


	public int getCount(TSiteDTO dto);
}
