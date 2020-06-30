#include<iostream>

using namespace std;


int main()
{
	int num;
	cin>>num;
	int count(0); 
	
	while(num>0)
	{
		if(num%5==0)
		{
			num -=5;
			count++;	
		}	
		else if(num%3==0)
		{
			num -=3;
			count++;
		}
		else if(num>5)
		{
			num -=5;
			count++;
		}
		else{
			count =-1;
			break;
		}
	}
	cout<<count;
}
