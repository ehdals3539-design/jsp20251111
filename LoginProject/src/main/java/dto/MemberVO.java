package dto;

public class MemberVO {
	
	private String userid;
	private String pwd;
	private String name;
	private String email;
	
	
	public MemberVO() {}
	
	public MemberVO(String userid, String pwd, String name, String email) {
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.userid = userid;
		
	}
	
	public String getUserid() { return userid; }
	public void setUserid(String userid) {this.userid = userid; }
	
	public String getpwd() { return pwd; }
	public void setpwd(String pwd) {this.pwd = pwd; }
	
	public String getname() { return name; }
	public void setname(String name) {this.name = name; }
	
	public String getemail() { return email; }
	public void setemail(String email) {this.email = email; }
	
	
	
	

}
