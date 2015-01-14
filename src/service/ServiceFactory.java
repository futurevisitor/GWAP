package service;

public class ServiceFactory implements IServiceFactory {

	@Override
	public IService createProductService() {
		// TODO Auto-generated method stub
		return new ProductService();
	}

	@Override
	public IService createCategoryService() {
		// TODO Auto-generated method stub
		return new CategoryService();
	}

	@Override
	public IService createUsersService() {
		// TODO Auto-generated method stub
		return new UsersService();
	}


	

	@Override
	public IService createContactInfoService() {
		// TODO Auto-generated method stub
		return new ContactInfoService();
	}

	@Override
	public IService createOrderListService() {
		// TODO Auto-generated method stub
		return new OrderListService();
	}

	@Override
	public IService createOrderDetailService() {
		// TODO Auto-generated method stub
		return new OrderDetailService();
	}

}
