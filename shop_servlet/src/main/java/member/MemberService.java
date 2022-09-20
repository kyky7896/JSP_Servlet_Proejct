package member;

public class MemberService {
    private MemberDao mdao;

    public MemberService(){
        mdao=new MemberDao();
    }
    //가입
    public void join(Member m){
        mdao.insert(m);

    }
    //로그인, 내정보확인
    public Member getMember(String id){
        return mdao.select(id);}
    //내정보수정
    public void editMember(Member m){
        mdao.update(m);
    }
    //탈퇴
    public void delMember(String id){
        mdao.delete(id);
    }
}
