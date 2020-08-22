#include<iostream>
using namespace std;

int main()
{
	int n;
	cin>>n;
	int count(0);
	
	
	while(n>0)
	{
		count++;
		n -= count;
	}
	
	if(count%2==0)
	{
		printf("%d/%d",count+n,1+(-n));	
	}
	else
	{
		printf("%d/%d",1+(-n),count+n);
	}
	
	
}
