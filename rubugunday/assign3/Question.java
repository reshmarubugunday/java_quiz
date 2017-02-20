package rubugunday.assign3;

public class Question {
	private String question;
	private String ansOpt1;
	private String ansOpt2;
	private String ansOpt3;
	private String ansOpt4;
	private String correctAns;
	private String clueImg;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnsOpt1() {
		return ansOpt1;
	}
	public void setAnsOpt1(String ansOpt1) {
		this.ansOpt1 = ansOpt1;
	}
	public String getAnsOpt2() {
		return ansOpt2;
	}
	public void setAnsOpt2(String ansOpt2) {
		this.ansOpt2 = ansOpt2;
	}
	public String getAnsOpt3() {
		return ansOpt3;
	}
	public void setAnsOpt3(String ansOpt3) {
		this.ansOpt3 = ansOpt3;
	}
	public String getAnsOpt4() {
		return ansOpt4;
	}
	public void setAnsOpt4(String ansOpt4) {
		this.ansOpt4 = ansOpt4;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	public String getClueImg() {
		return clueImg;
	}
	public void setClueImg(String clueImg) {
		this.clueImg = clueImg;
	}
	public Question(String question, String ansOpt1, String ansOpt2, String ansOpt3, String ansOpt4, String correctAns,
			String clueImg, String category) {
		super();
		this.question = question;
		this.ansOpt1 = ansOpt1;
		this.ansOpt2 = ansOpt2;
		this.ansOpt3 = ansOpt3;
		this.ansOpt4 = ansOpt4;
		this.correctAns = correctAns;
		this.clueImg = clueImg;
		this.category = category;
	}
	
	
}
