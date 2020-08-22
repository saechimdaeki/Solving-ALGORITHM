#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> v;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(7);
	int sum(0);
	int min;
	for(int i=0; i<7; i++)
	{
		cin>>v[i];
		if(v[i]%2!=0)
			min=v[i];
	}
	for(int i=0; i<7; i++)
	{
		if(v[i]%2!=0)
		{
			sum+=v[i];
			if(v[i]<min)
			min=v[i];	
		}
	}
	if(sum==0)
	cout<<"-1"; 
	else
	{
		cout<<sum<<"\n";
	cout<<min;
		
	}
	
}
