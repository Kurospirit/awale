public class IA
{
	String side;
	int score;
	String name;

	public IA(String side)
	{
		this.side = side;
		this.name = "IA-" + side;
		this.score = 0;
	}
	
	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return this.score;
	}

	public void addScore(int value){
		setScore(getScore() + value);
	}
	
	public void jouer(Plateau plateau)
	{
		
	}
}
