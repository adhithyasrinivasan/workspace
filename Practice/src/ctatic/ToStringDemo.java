package ctatic;

public class ToStringDemo {
	
	public static void main(String[] args) {
		Tostring nn= new Tostring(10);
		System.out.println(nn.toString());
	}
	

}


class Tostring
{
	int innt;
	public Tostring(int aa)
	{
		this.innt=aa;
	}
	@Override
	public String toString()
	{
		return new String("integer "+innt);
	}
}
