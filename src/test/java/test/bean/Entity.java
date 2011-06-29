package test.bean;

import java.util.Date;

/**
 * User: phoenixup Date: 11-5-10 Time: 下午3:27
 */
public class Entity {
	private Date date;
	private Receipty[] receipts;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Receipty[] getReceipts() {
		return receipts;
	}

	public void setReceipts(Receipty[] receipts) {
		this.receipts = receipts;
	}
}
