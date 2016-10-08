package deity.domain.ognl;

public class Card {
	private Integer id;
	private String cardId;
	
	public static String staticFiled = "staticfiled";
	public static String staticMethod() {
		return "getStaticMethod";
	}
	
	public Card(Integer id, String cardId) {
		this.id = id;
		this.cardId = cardId;
	}
	public Card() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@Override
	public String toString() {
		return "" + id + "-->" + cardId + "";
	}
}
