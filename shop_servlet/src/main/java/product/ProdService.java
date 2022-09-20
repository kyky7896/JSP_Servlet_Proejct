package product;

import java.util.ArrayList;

public class ProdService {
    private ProdDao pdao;

    public ProdService(){
        pdao=new ProdDao();
    }


    // 상품등록
    public void addProduct(Product p) {
        pdao.insert(p);
    }

    public int makeNum() {
        return pdao.makeNum();
    }

    // 내 등록 상품 목록. 판매자로 상품검색
    public ArrayList<Product> getBySeller(String seller) {
        return pdao.selectBySeller(seller);
    }
    // 수정(상품 이름, 설명, 가격, 수량)
    public void editProduct(Product p) {
        pdao.update(p);
    }

    public void editAmount(int num,int amount){
        pdao.updateAmount(num,amount);
    }

    // 삭제
    public void delProduct(int num) {
        pdao.delete(num);
    }
    // 상품 번호로 검색
    public Product getByNum(int num) {
        return pdao.selectByNum(num);
    }
    // 상품명으로 검색
    public ArrayList<Product> getByName(String name) {
        return pdao.selectByName(name);
    }
    // 가격대로 검색
    public ArrayList<Product> getByPrice(int price1, int price2) {
        return pdao.selectByPrice(price1,price2);
    }
    // 전체검색
    public ArrayList<Product> getAll() {
        return pdao.selectAll();
    }

}
