package Automation;

import java.util.Random;

public class MyData {
	
	Random rand = new Random(); 
	
	String [] firstNames = {"shatha","zainab","ayham","abdulrahman","ammar","sana","khaled"};

	String [] lastNames = {"Mohammad","mahmoud","ali","omar","anas","rami"};
	
	int randomNumberForTheEmail = rand.nextInt(19845);

	String domain = "@gmail.com"; 
	
	int RandomFirstNameIndex = rand.nextInt(firstNames.length);
	int RandomLastNameIndex = rand.nextInt(lastNames.length);


    String TheFirstName = firstNames[RandomFirstNameIndex];
	String TheLastName = lastNames[RandomLastNameIndex];
    String TheEmail = TheFirstName+TheLastName+randomNumberForTheEmail+domain; 
	String TelePhone = "96279770023";
	String TheFaxNumber = "133810";
	String TheAddressOne = "Amman- Jordan";
	
	int TheSelectStateIndex = rand.nextInt(1,10);

	String PostalCode = "2451245";
	String LoginName = TheFirstName + TheLastName + randomNumberForTheEmail ; 
	String Password = "P@$$w0rd";
	String ExpectedTextForTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
	String ExpectedLogOutText = "You have been logged off your account. It is now safe to leave the computer.";
	String WelcomMessage = "Welcome back " + TheFirstName;
}
