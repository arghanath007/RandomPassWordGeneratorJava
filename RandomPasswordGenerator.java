import java.util.*;

class RandomPasswordGenerator 
{
    public static void main(String[] args) 
    {
		int mixer=1,upCase,loCase,digits,special;
		upCase=loCase=digits=special=0;
	    Scanner in = new Scanner(System.in);
		System.out.print("How many random passwords do you want to generate? ");
		int total = in.nextInt();
		System.out.print("How long do you want your random passwords to be? ");
		int length = in.nextInt();
		System.out.println("If you want a mixer of all then press 0: ");
		mixer=in.nextInt();
		if(mixer !=0)
		{
			System.out.println("Enter your choices 1 for YES and 2 for NO, \nUpperCase\nLowerCase\nDigits\nSpecialCharacters");
			upCase=in.nextInt();
			loCase=in.nextInt();
			digits=in.nextInt();
			special=in.nextInt();
		}
		//Array Of Passwords
		String[] randomPasswords = new String[total];
		for(int i = 0; i < total; i++) 
        {
			//Generating Random Passwords
			String randomPassword = "";
			//Generating Random characters of the password
			for(int j = 0; j < length; j++) 
            {
				randomPassword += randomCharacter(upCase,loCase,digits,special,mixer);
			}
			randomPasswords[i] = randomPassword;
		}
		//Displaying Passwords
		printArray(randomPasswords);

    }
    //Display Function
	public static void printArray(String[] arr) 
    {
		for(int i = 0; i < arr.length; i++) 
        {
			System.out.println(arr[i]);
		}
	}
	//'0' - '9' => 48-57 in ASCII
	//'A' - 'Z' => 65-90 in ASCII
	//' ' - '/' => 32-47 in ASCII
	//'a' - 'z' => 97-122 in ASCII
	public static char randomCharacter(int upCase, int loCase,int digits,int special, int mixer) 
    {
		if(mixer == 0)
		{
			//We multiply Math.random() by 78 because there are 26 lowercase letters, 26 uppercase letters, 16 special case characters and 10 numbers, and 26 + 26 + 10 + 16 = 78
			//This random number has values between 0 (inclusive) and 78 (exclusive)
			int rand = (int)(Math.random()*78);
			if(rand <= 9) 
			{
				//To convert from 0-9 to 48-57, we can add 48 to rand because 48-0 = 48
				int number = rand + 48;
				return (char)(number);
			} 
			else if(rand <= 35) 
			{
				//To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
				int uppercase = rand + 55;
				return (char)(uppercase);
			} 
			else if(rand <= 51 )
			{
				//To convert 36-52 to 32-47, we need to substract 4 because 36-32=4
				int specialNum= rand -4;
				return (char)(specialNum);
			}
			else 
			{
				//To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
				int lowercase = rand + 61;
				return (char)(lowercase);
			}
		}
		else
		{
			
			int randNumber;
			if(upCase == 1)
			{
				if(loCase == 1)
				{
					//26 + 26= 52;
					int upLow=0;
					randNumber=(int)(Math.random()*52);
					if(randNumber <= 25 || randNumber >=31)
					{
						upLow=randNumber+65;
					}
					else
					{
						upLow= randNumber+ 70;
					}
					return (char)upLow;
				}
				if(digits == 1)
				{
					int upDig;
					//26+9=35
					randNumber=(int)(Math.random()*35);
					if(randNumber <= 9)
					{
						upDig= randNumber;
					}
					else
					{
						upDig=randNumber+87;
					}
					return (char) upDig;
				}
				if(special == 1)
				{
					int upSpecial;
					//26+ 14=40
					randNumber=(int)(Math.random()*40);
					if(randNumber <= 14 )
					{
						upSpecial= randNumber + 33;
					}
					else
					{
						upSpecial= randNumber + 65;
					}
					return (char)upSpecial;
				}
				else
				{
					//26
					int upOnly;
					randNumber=(int)(Math.random()*26);
					upOnly= randNumber + 65;
					return (char)(upOnly);
				}
				
			}
			else if(loCase == 1)
			{
				if(digits == 1)
				{
					int loDig;
					//26+9=35
					randNumber=(int)(Math.random()*35);
					if(randNumber <= 9)
					{
						loDig= randNumber;
					}
					else
					{
						loDig=randNumber+87;
					}
					return (char) loDig;
				}
				if(special == 1)
				{
					int loSpecial;
					//26+ 14=40
					randNumber=(int)(Math.random()*40);
					if(randNumber <= 14 )
					{
						loSpecial= randNumber + 33;
					}
					else
					{
						loSpecial= randNumber + 81;
					}
					return (char) loSpecial;
				}
				else
				{
					//26
					int loOnly;
					randNumber=(int)(Math.random()*26);
					loOnly= randNumber + 97;
					return (char)(loOnly);

				}
			}
			else if(digits == 1)
			{
				if(special == 1)
				{
					int digitSpecial;
					//9 + 14 = 23
					randNumber=(int)(Math.random()*23);
					if(randNumber <= 9 )
					{
						digitSpecial= randNumber;
					}
					else
					{
						digitSpecial= randNumber + 23 ;
					}
					return (char)digitSpecial;
				}
				else
				{
					//9
					int digitOnly;
					randNumber=(int)(Math.random()*9);
					digitOnly= randNumber + 48;
					return (char)digitOnly;
				}
			}
			else
			{
				//14
				int specialOnly;
				randNumber=(int)(Math.random()*14);
				specialOnly= randNumber + 33;
				return (char)specialOnly;
			}
		}
		// return ' ';
	}
}


//Add special characters as well.
//Let the user choose between if he want lower or uppercase or digits only or some combination of them.