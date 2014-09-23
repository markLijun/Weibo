package model;


import java.util.*;



import DAO.AccountDAO;
import DAO.BlahDAO;


public class Service {
	
	private LinkedList<Blah> newest = new LinkedList<>();
	private AccountDAO accountDAO;
	private BlahDAO blahDAO;
	
	public Service (AccountDAO accountDAO,BlahDAO blahDAO) {
		this.accountDAO = accountDAO;
		this.blahDAO = blahDAO;
	}
	
	public boolean isUserExisted (Account account) {
		
		return accountDAO.isUserExisted(account);
	}
	
	public void addAccount (Account account) {
		accountDAO.addAccount(account);
	}	
	
	public boolean checkLogin (Account account) {
		Account acct = accountDAO.getAccount(account);
		boolean login = false;
		if (account.getName() != null && account.getPassword() != null) {
			if(acct != null) {
				if(account.getPassword().equals(acct.getPassword())){
					login = true;
				}
				
			}
		}
		return login;
	}
	
	private class DateComparator implements Comparator<Blah> {
		@Override
		public int compare(Blah b1,Blah b2) {
			return -b1.getDate().compareTo(b2.getDate());
		}
	}
	
	private DateComparator comparator = new DateComparator();
	
	public List<Blah> getBlahs(Blah blah) {
		List<Blah> blahs = blahDAO.getBlahs(blah);
		Collections.sort(blahs,comparator);
		return blahs;
	}
	
	public void addBlah (Blah blah) {
		blahDAO.addBlah(blah);
		newest.addFirst(blah);
		if(newest.size()>20) {
			newest.removeLast();
		}
	}
	
	public void deleteBlah (Blah blah) {
		blahDAO.deleteBlah(blah);
		newest.remove(blah);
	}
	
	public List<Blah> getNewest () {
		return newest;
	}
	}
