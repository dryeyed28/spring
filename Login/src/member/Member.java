package member;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String msg;
	
	public Member() {}

	public Member(String id, String pwd, String name, String msg) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", msg=" + msg + "]";
	}
	

}
