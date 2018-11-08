package collections;

public class AnonymousInner {
	
private	int rand=1;
	public class Inner
	{
		private int retrun()
		{
			return rand;
		}
	}
public static void main(String args[])
{
	System.out.println(new AnonymousInner().new Inner().retrun());
}
}
