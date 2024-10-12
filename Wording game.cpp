#include <iostream>
#include <cstdlib>
#include <ctime>
#include<windows.h>


using namespace std;

void changeColor(int color) {
   SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color);
   
}
int main()
{ 
start:
   string a[8] = {"hello" , "world" , "coding" , "apple" , "bat" , "fish" , "ball" , "right"};
     srand(time(0));
	int ran = rand() % 8 ;
	int i , j;
	string word = a[ran];
	string ranword = a[ran];
	char letter;
	
   HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);

    // Set the text color to yellow, background color to blue, and make the text bold
    SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN | BACKGROUND_BLUE | FOREGROUND_INTENSITY);

    // Change console window size
    SMALL_RECT rect = {0, 0, 80, 25};  // Set the size of the console window (80 columns x 25 rows)
    SetConsoleWindowInfo(hConsole, TRUE, &rect);

    
   cout << "										Welcome" << std::endl;

    // Reset the console text attributes to default
    SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE);
		cout<<"====================================================="<<endl;
	cout<<"You have "<<word.length()+3<<" chances to guess the "<<word.length()<<" letter word."<<"      ="<<endl;
	cout<<"==========================================================="<<endl;
	if(1==1){
		  changeColor(14);
	cout<<"Red text indicates the character in previous line is wrong"<<endl;//role
  changeColor(7);
}
	cout<<"==========================================================="<<endl;
	cout<<": Hint :           ="; 
	
    switch(ran)
    {
    	case 0:
    	cout<<endl<<"Used for greeding:"<<endl;
    	break;
    	
    	case 1:
    	cout<<endl<<"Where we live:"<<endl;
    	break;
    	
    	case 2:
    	cout<<endl<<"Programmer always doing:"<<endl;
    	break;
    	
    	case 3:
    	cout<<endl<<"Eatable thing:"<<endl;
    	break;
    	
    	case 4:
    	cout<<endl<<"Used to play:"<<endl;
    	break;
    	
    	case 5:
    	cout<<endl<<"only in water:"<<endl;
    	break;
    	
    	case 6:
    	cout<<endl<<"Used to play:"<<endl;
    	break;
    	
    	case 7:
    	cout<<endl<<"synonym of correct:"<<endl;
    	break;
    	
    	default:
    	cout<<endl<<"Error in Hinting:"<<endl;
    	break;
	}
	
	for(i=1; i<=word.length()+3; i++)
	{	cout<<"chance: "<<i<<" Enter the letter of word: ";cin>>letter;
        for(j=0; j<word.length(); j++)
	      	{if(letter == word[j])
		        {
		        	changeColor(10);
			        cout<<letter<<" is present in the word at "<<j+1<<" position"<<endl;
			        word[j] = '1';
			        changeColor(7);
	break;
		        }
	        }
	    if(j==word.length())
	    {
	    	 changeColor(12);
	    	cout<<letter<<" isn't present in the word may be you already put in"<<endl;
	    changeColor(7);
	    
		}
		if(word == string(word.length(),'1'))
		{
			
			cout<<"========================================";
			changeColor(10);
			cout<<endl<<"=  Congratulation You win the game"<<"     ="<<endl;
			changeColor(7);
			cout<<"========================================"<<endl;
			changeColor(10);
		    break;
		}	
	}
		if(word != string(word.length(),'1'))
		{
				cout<<"========================================"<<endl;
			cout<<endl<<"Game over , better luck next time"<<"     ="<<endl;
				cout<<"========================================"<<endl;
				changeColor(12);
		}
			changeColor(7);
				
				cout<<"========================================"<<endl;
		cout<<"=            The word is "<<ranword<<"          ="<<endl;
		
		cout<<"========================================"<<endl;
		char restart;
	
		cout<<"if you want to restart the program please press (y/n):";
	 	cin>>restart;
	 	 if(restart=='y' || restart=='Y'){
		 	system("cls");
		 	goto start;
		 }
	 	
		
system("PAUSE");
return 0;
}

