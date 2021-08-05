package boardbean;

public class BoardDTO {
	long seq = 0;                    	//글번호
    String id = "";               		//아이디
    String name = "";             		//이름
    String subject;         			//제목
    String content;         			//내용
    long hit = 0;						//조회수
    String logtime;            			//작성일
    
    
    public BoardDTO() {}
	public BoardDTO(String id, String name, String subject, String content) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.content = content;
	}
	
	public BoardDTO(long seq, String id, String name, String subject, String content, long hit, String logtime) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.logtime = logtime;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
    
}
