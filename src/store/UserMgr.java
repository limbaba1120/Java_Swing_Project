package store;

import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class UserMgr extends Manager implements DataEngineInterface{
	private static UserMgr mgr = null;
	private UserMgr() {}
	public static UserMgr getInstance() {
		return mgr;
	}
	private String[] headers = {"id", "point", "wait-point"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
	}
	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return Store.userMgr.findAll(kwd);
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
