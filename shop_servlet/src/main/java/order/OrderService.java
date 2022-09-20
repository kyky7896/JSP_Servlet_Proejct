package order;

import java.util.ArrayList;

public class OrderService {

    OrderDao odao;

    public OrderService(){
        odao=new OrderDao();
    }
    //주문
    public void addOrder(Order o){
        odao.insert(o);
    }

    //내 주문 목록 : ispay가 true인 consumer의 주문목록!
    public ArrayList<Order> myOrderList(String consumer){
        return odao.selectByConsumer(consumer);
    }

    //결제 기준 검색 -> 장바구니, 결제 대상 목록, 취소 대상 목록, 결제내역
    public ArrayList<Order> getByPay(boolean pay,String consumer){
        return odao.selectByPay(pay,consumer);

    }

    //결제
    public void editPay(int num,String addr){
        odao.updatePay(num,addr);

    }

    //주문 수정(주문수량, 만 수정)
    public void editOrder(Order o){
        odao.update(o);

    }

    //주문 번호로 검색 : 상세내역
    public Order getByNum(int num){
        return odao.select(num);

    }

    //주문취소 ispay선택
    public void delOrder(int num,Boolean ispay){
        odao.delete(num,ispay);
    }

}
