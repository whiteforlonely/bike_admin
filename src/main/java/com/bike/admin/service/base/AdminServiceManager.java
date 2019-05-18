package com.bike.admin.service.base;

import com.bike.admin.service.TAdminUserService;
import com.bike.admin.service.TBikeService;
import com.bike.admin.service.TSiteService;
import com.bike.admin.service.TUserInfoService;
import com.bike.admin.service.TUserOrderService;
import com.bike.admin.service.impl.TAdminUserServiceImpl;
import com.bike.admin.service.impl.TBikeServiceImpl;
import com.bike.admin.service.impl.TSiteServiceImpl;
import com.bike.admin.service.impl.TUserInfoServiceImpl;
import com.bike.admin.service.impl.TUserOrderServiceImpl;

public class AdminServiceManager {

	private static TAdminUserService adminUserService;
	private static TSiteService tSiteService;
	private static TUserInfoService tUserInfoService;
	private static TBikeService tBikeService;
	private static TUserOrderService tUserOrderService;
//	private static AdminUserOprRecordsService adminUserOprRecordsService;
	
	public static TAdminUserService getAdminUserService(){
		if (adminUserService == null) {
			synchronized (TAdminUserService.class) {
				if (adminUserService == null) {
					adminUserService = new TAdminUserServiceImpl();
				}
			}
		}
		return adminUserService;
	}
	
	public static TSiteService getTSiteService(){
		if (tSiteService == null) {
			synchronized (TSiteService.class) {
				if (tSiteService == null) {
					tSiteService = new TSiteServiceImpl();
				}
			}
		}
		return tSiteService;
	}
	
	public static TUserInfoService getTUserInfoService(){
		if (tUserInfoService == null) {
			synchronized (TUserInfoService.class) {
				if (tUserInfoService == null) {
					tUserInfoService = new TUserInfoServiceImpl();
				}
			}
		}
		return tUserInfoService;
	}
	
	public static TBikeService getTBikeService(){
		if (tBikeService == null) {
			synchronized (TBikeService.class) {
				if (tBikeService == null) {
					tBikeService = new TBikeServiceImpl();
				}
			}
		}
		return tBikeService;
	}
	
	public static TUserOrderService getTUserOrderService(){
		if (tUserOrderService == null) {
			synchronized (TUserOrderService.class) {
				if (tUserOrderService == null) {
					tUserOrderService = new TUserOrderServiceImpl();
				}
			}
		}
		return tUserOrderService;
	}
	
//	public static AdminUserOprRecordsService getAdminUserOprRecordsService(){
//		if (adminUserOprRecordsService == null) {
//			synchronized (AdminUserOprRecordsService.class) {
//				if (adminUserOprRecordsService == null) {
//					adminUserOprRecordsService = new AdminUserOprRecordsServiceImpl();
//				}
//			}
//		}
//		return adminUserOprRecordsService;
//	}
}
