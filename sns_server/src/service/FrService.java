package service;

import java.util.ArrayList;

public interface FrService {
	
	boolean getFr(String id, String fr_id);
	ArrayList getFr_sgList(int sg, String id);
	void reqFr(String id, String fr_id);
	void addFr(String id, String fr_id);
	ArrayList getFrIdList(String id);
	ArrayList getFrList(String id);
	void delFr(String id, String fr_id);
}
