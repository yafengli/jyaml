package test.bean;

import java.util.Date;
import java.util.HashSet;

/**
 * User: phoenixup
 * Date: 11-5-10
 * Time: 下午3:27
 */
public class Entity {
	private Date date;
	private HashSet<Receipty> receipts;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public HashSet<Receipty> getReceipts() {
		return receipts;
	}

	public void setReceipts(HashSet<Receipty> receipts) {
		this.receipts = receipts;
	}
}
