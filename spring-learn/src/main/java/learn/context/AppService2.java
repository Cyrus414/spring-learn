package learn.context;

class AppService2 {

	private AppService1 appService1;

	public AppService2() {
		System.out.println("Constructor AppService2");
	}

	public void setAppService1(AppService1 appService1) {
		this.appService1 = appService1;
	}
}
