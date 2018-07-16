package test.bean;

import java.util.Date;

/**
 * User: phoenixup Date: 11-5-10 Time: 下午3:27
 */
public class Entity {
  private Date date;
  private Date birthday;
  private Receipty[] receipts;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Receipty[] getReceipts() {
    return receipts;
  }

  public void setReceipts(Receipty[] receipts) {
    this.receipts = receipts;
  }
}
