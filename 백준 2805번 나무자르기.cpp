#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n;
long long m,answer;
vector<long long > v;
long long leftt=1,rightt;
bool possible(long long n1)
{
	long long sum=0;
	for(int i=0; i<n; i++)
	{
		if(v[i]-n1>0)
		sum+=(v[i]-n1);
	}
	if(sum>=m)
	return true;
	
	return false;
}

int main()
{
	
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];	

	rightt=*max_element(v.begin(),v.end());
	while(leftt<=rightt)
	{
		long long mid=(leftt+rightt)/2;
		if(possible(mid))
		{
			answer=mid;
			leftt=mid+1;
		}else
		rightt=mid-1; 
	}
	cout<<answer;
}
