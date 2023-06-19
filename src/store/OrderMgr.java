package store;

import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class OrderMgr implements DataEngineInterface  {
	private static OrderMgr mgr = null;
	private OrderMgr() {}
	public static OrderMgr getInstance() {
		if (mgr == null)
			mgr = new OrderMgr();
		return mgr;
	}
	public Order getOrder(int index) {
		return (Order)Store.orderMgr.mList.get(index);
	}
	private String[] headers = {"아이디", "상품명", "가격", "냉장고", "개수"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return Store.orderMgr.findAll(kwd);
	}
	@Override
	public void addNewItem(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(String kwd) {
		// TODO Auto-generated method stub
		
	}
}
