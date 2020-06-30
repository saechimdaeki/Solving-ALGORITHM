#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
long long m,answer;
int leftt=0,rightt;
bool possible(int n1)
{
	int sum(0);
	for(auto i:v)
	sum+=min(i,n1);
	if(sum>m)
	return false;
	return true;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n;i++)
	cin>>v[i];
	cin>>m;
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
