#include<iostream>
using namespace std;

int main()
{
	int n;
	cin>>n;
	
	int count(1);
	int range=1;
	int tmp=1;
	
	while(1)
	{
		if(range>=n)
		{
			break;
		}
			tmp=6*(count++);
			range+=tmp;
	}
	cout<<count;
	
 } 
 
