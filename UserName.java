import java.util.Hashtable;


public class UserName {
	
	
	public 	static String newMember(String[] existingNames, String newName)
	{
		String availableName="";
		Hashtable<String,byte[]> table=new Hashtable<String,byte[]>();
		initializeHashtable(table,existingNames);
		availableName=checkForExistingUserNames(newName,table);
		return availableName;
	}
	
	public static void initializeHashtable(Hashtable<String,byte[]> table,String[] existingNames)
	{
		for(String name:existingNames)
		{
			String[] userName=name.split("[^A-Za-z0-9]+|(?<=[A-Za-z])(?=[0-9])|(?<=[0-9])(?=[A-Za-z])");
			byte[] bitVector;
			if(!table.containsKey(userName[0]))
			{
				bitVector=new byte[0XFFFFFFF/8];
			}
			else
			{
				bitVector=table.get(userName[0]);	
			}
				if(userName.length>1)
				{
					int num=Integer.parseInt(userName[1]);
					bitVector[num/8]|=1<<num%8;
				}
				else
				{
					bitVector[0]|=1<<0;
				}
				table.put(userName[0],bitVector);
			}
		}
	
	public static String checkForExistingUserNames(String newName,Hashtable<String,byte[]> table)
	{
		byte[] bitVector;
		if(table.containsKey(newName))
		{
			bitVector=table.get(newName);
			for(int i=0;i<bitVector.length;i++)
			{
				byte b=bitVector[i];
				for(int j=0;j<8;j++)
				{
					if((b&1<<j)==0)
					{
						if(j==0 && i==0) return newName;
						else
						{
						newName+=(i*8)+j;
						return newName;
						}
					}
				}
			}
		}
		return newName;
		
	}
	public static void main(String[] args)
	{
		String[] str={"Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10",
				 "Lisa", "Marge", "Homer", "Bart", "Bart1", "Bart2", "Bart3",
				 "Bart11", "Bart12"};
		String newName=newMember(str,"Bart");
		System.out.println(newName);
	}
	}


