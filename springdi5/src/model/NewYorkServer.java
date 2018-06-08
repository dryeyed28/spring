package model;

public class NewYorkServer implements Server {

	@Override
	public void service() {
		System.out.println("뉴욕 서버 서비스");
	}

}
