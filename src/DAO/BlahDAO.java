package DAO;

import java.util.*;

import model.Blah;

public interface BlahDAO {

	List<Blah> getBlahs (Blah blah);
	
	void addBlah (Blah blah);
	
	void deleteBlah (Blah blah);
	
}
