package am.vo;

public class MemberVO {
	//member_t에서 필요한 컬럼들을 모두 멤버변수로 선언
	private String m_idx, m_id, m_name, m_email, m_phone, write_date;

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	
	
	public String getM_idx() {
		return m_idx;
	}

	public String getM_id() {
		return m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public String getM_phone() {
		return m_phone;
	}

	public String getWrite_date() {
		return write_date;
	}
	
	
}
