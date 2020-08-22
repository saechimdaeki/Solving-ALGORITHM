#include<iostream>
using namespace std;

int fourORseven(int n)
{
	while(n)
	{
		int digit=n%10;
		n/=10;
		if(digit==4||digit==7)
			continue;
			else
			{
				goto zero; 
			}
	}
	return 1;
	zero: return 0;
	
		
}

int main()
{
	int n; cin>>n;
	int answer;
	for(int i=4; i<=n; i++)
	{
		if(fourORseven(i)==1)
		answer=i;
	 } 
	 cout<<answer<<endl;
	
}
