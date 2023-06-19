package store;

import java.util.List;
import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class CornMgr implements DataEngineInterface {
	private static CornMgr mgr = null;
	private CornMgr() {}
	public static CornMgr getInstance() {
		if (mgr == null)
			mgr = new CornMgr();
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
		return Store.cornMgr.findAll(kwd);
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