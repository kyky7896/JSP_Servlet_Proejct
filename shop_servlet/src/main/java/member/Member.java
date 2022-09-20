package member;

public class Member {
    private String id;
    private String pwd;
    private boolean mem_type;
    private String tel;
    private String addr;

    public Member() {
    }

    public Member(String id, String pwd, boolean mem_type, String tel, String addr) {
        this.id = id;
        this.pwd = pwd;
        this.mem_type = mem_type;
        this.tel = tel;
        this.addr = addr;
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

    public boolean isMem_type() {
        return mem_type;
    }

    public void setMem_type(boolean mem_type) {
        this.mem_type = mem_type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mem_type=" + mem_type +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
