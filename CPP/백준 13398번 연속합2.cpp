#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> Leftv,Rightv,arr;
int n,answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	Leftv.resize(n);
	Rightv.resize(n);
	arr.resize(n);
	for(int i=0; i<n; i++)
	cin>>arr[i];
	for(int i=0; i<n; i++)
	{
		Leftv[i]=arr[i];
		if(i==0)
		continue;
		Leftv[i]=max(Leftv[i],Leftv[i-1]+arr[i]);	
	}
	for(int i=n-1; i>=0; i--)
	{
		Rightv[i]=arr[i];
		if(i==n-1)
			continue;
		Rightv[i]=max(Rightv[i],Rightv[i+1]+arr[i]);	
	}
	 answer=Leftv[0];
	for(int i=0; i<n; i++)
	answer=max(Leftv[i],answer);
	for(int i=1; i<n-1; i++)
		answer=max(answer,Leftv[i-1]+Rightv[i+1]);
		
		cout<<answer;
}
 
