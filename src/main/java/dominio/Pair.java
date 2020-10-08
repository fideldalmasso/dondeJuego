package dominio;

public class Pair{
	private Integer id;
	private Integer first;
	private Integer second;
	public Pair(Integer id,Integer first, Integer second) {
		super();
		this.id = id;
		this.first = first;
		this.second = second;
	}
	public Pair(Integer id) {
		super();
		this.id = id;
	}
	public Pair() {
		super();
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	
	
}
