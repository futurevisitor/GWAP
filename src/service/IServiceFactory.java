package service;

public interface IServiceFactory {
	
	public IService createProductService() ;
	public IService createCategoryService() ;
	public IService createUsersService();
	public IService createContactInfoService();
	public IService createOrderListService();
	public IService createOrderDetailService();

}
