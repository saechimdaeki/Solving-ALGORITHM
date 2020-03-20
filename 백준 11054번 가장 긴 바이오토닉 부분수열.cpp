#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,answer;
vector<int> arr,plusis,minusis;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	arr.resize(n);
	plusis.resize(n);
	minusis.resize(n);
	for(int i=0; i<n; i++)
	cin>>arr[i];
	for(int i=0; i<n; i++)
	{
		plusis[i]=1;
		for(int j=0; j<i; j++)
			if(arr[j]<arr[i] && plusis[j]+1>plusis[i])
				plusis[i]=plusis[j]+1;
		
	}
	for(int i=n-1; i>=0; i--)
	{
		minusis[i]=1;
		for(int j=i+1; j<n; j++)
			if(arr[i]>arr[j] &&minusis[j]+1>minusis[i])
				minusis[i]=minusis[j]+1;
	}
	for(int i=0; i<n; i++)
		answer=max(answer,plusis[i]+minusis[i]-1);
	cout<<answer;	
	
}
