#include<iostream>
#include<algorithm>
using namespace std;

int number[10];

int main()
{
	int save,n;
	cin>>n;
	while(true)
	{
		number[n%10]++;
		if(n/10==0)
		break;
		n/=10;
	}
	
	for(int i=0; i<10; i++)
	{
		if(i !=9 && i !=6)
		save=max(save,number[i]);
	}
	cout<<max(save,(number[6]+number[9]+1)/2);
			
} 
