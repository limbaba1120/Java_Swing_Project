package store;

import java.util.List;
import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class BarMgr implements DataEngineInterface {
	private static BarMgr mgr = null;
	private BarMgr() {}
	public static BarMgr getInstance() {
		if (mgr == null)
			mgr = new BarMgr();
		return mgr;
	}
	private String[] headers = {"code", "name", "price", "stock", "location"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return Store.barMgr.findAll(kwd);
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
