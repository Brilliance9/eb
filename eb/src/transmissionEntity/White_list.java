package transmissionEntity;

import java.util.Arrays;

public class White_list {

	private int oper_type;
	private int phone_number_length;
	private String phone_number;
	private int user_name_length;
	private String user_name;
	private int permission_type;
	private int permission_area_number;
	private int permission_area_length;
	private String[] permission_area_code;
	
	public int getOper_type() {
		return oper_type;
	}
	public void setOper_type(int oper_type) {
		this.oper_type = oper_type;
	}
	public int getPhone_number_length() {
		return phone_number_length;
	}
	public void setPhone_number_length(int phone_number_length) {
		this.phone_number_length = phone_number_length;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getUser_name_length() {
		return user_name_length;
	}
	public void setUser_name_length(int user_name_length) {
		this.user_name_length = user_name_length;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getPermission_type() {
		return permission_type;
	}
	public void setPermission_type(int permission_type) {
		this.permission_type = permission_type;
	}
	public int getPermission_area_number() {
		return permission_area_number;
	}
	public void setPermission_area_number(int permission_area_number) {
		this.permission_area_number = permission_area_number;
	}
	public int getPermission_area_length() {
		return permission_area_length;
	}
	public void setPermission_area_length(int permission_area_length) {
		this.permission_area_length = permission_area_length;
	}
	public String[] getPermission_area_code() {
		return permission_area_code;
	}
	public void setPermission_area_code(String[] permission_area_code) {
		this.permission_area_code = permission_area_code;
	}
	@Override
	public String toString() {
		return "White_list [oper_type=" + oper_type + ", phone_number_length=" + phone_number_length + ", phone_number="
				+ phone_number + ", user_name_length=" + user_name_length + ", user_name=" + user_name
				+ ", permission_type=" + permission_type + ", permission_area_number=" + permission_area_number
				+ ", permission_area_length=" + permission_area_length + ", permission_area_code="
				+ Arrays.toString(permission_area_code) + "]";
	}
	
}
