#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
#include<cmath>
using namespace std;
int n,m;
bool error[10];
int cnt;

bool possible(int num)
{
	if(num==0)
	{
		if (error[0])
		return false;
		else 
		return true;
		
	}
	while(num)
	{
		if(error[num%10])
		return false;
		num/=10;
	}
	return true;
}
int counting(int n1)
{
	
	int tmp=abs(n1-100);
	int minimum(2e9+1);
	int temp;
	for(int i=0; i<500000*2; i++)
	{
		if(possible(i))
		{
			temp = to_string(i).length();
			temp += abs(i-n1);
			minimum = min(minimum,temp);
		}
	}			
	return min(tmp,minimum);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;	
	
	for(int i=0; i<m; i++)
	{
		int a;
		cin>>a;
		error[a]=true;
	}
	//cout<<counting();	
	cout<<counting(n);
			
}
