#include<iostream>
using namespace std;

int main()
{
	int n;
	cin>>n; 
	n--;
	int again(n/14);//
	int turuturu(2+again);//부를때마다 ru 추가  
	
	int sing(n%14);
	
	if(sing ==0 || sing ==12)
	cout<<"baby";
	else if(sing==1 ||sing ==13)
	cout<<"sukhwan";
	else if(sing ==4)
	cout<<"very";
	else if(sing ==5)
	cout<<"cute";
	else if(sing==8)
	cout<<"in";
	else if(sing==9)
	cout<<"bed";
	else
	{
		
		turuturu -= sing %2;
		if(turuturu>=5)
		cout<<"tu+ru*"<<turuturu;
		else
		{
			cout<<"tu";
			for(int i=0; i<turuturu; i++)
			cout<<"ru";
		}
	}
}
