package POJOclassforParsing;

import java.util.Random;

public class RandomNumber {
	public int getrandomNumber(int bound)
	{
		return new Random().nextInt(bound);
	}

}
