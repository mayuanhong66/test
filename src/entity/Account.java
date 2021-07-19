package entity;

public class Account {
    private String name;
    private String amount;
    private String time;
    private String money;
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setAmount(String a) {
        amount=a;
    }
    public String getAmount() {
        return amount;
    }
    public void setTime(String b) {
        time=b;
    }
    public String getTime() {
        return time;
    }
    public void setMoney(String c) {
        money=c;
    }
    public String getMoney() {
        return money;
    }
    public Account() {
    }
    public Account(String a,String b,String c,String d) {
        name=a;
        amount=b;
        money=c;
        time=d;
    }
}
