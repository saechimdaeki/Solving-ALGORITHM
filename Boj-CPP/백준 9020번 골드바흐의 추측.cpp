#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int gold(int n)
{
	if(n==1)
	return 0;
	else if(n==2)
	return 123456;
	
	
	else{
		for(int i=2; i<=sqrt((double)n); i++)
		{
			if(n%i==0)
			return 0;
		}
	}
	return 123456;
}

int main()
{
	int t;
	int n;
	int abc,def;
	cin>>t;
	for(int i=0; i<t; i++)
	{
		cin>>n;
		for(int a=0; a<=n/2; a++)
		{
			if(n<a)
			break;
		
		if(gold(a)&&gold(n-a))
		{
			abc=a;
			def=n-a;
		}
	}
	cout<<abc<<" "<<def<<endl;
	}
}


