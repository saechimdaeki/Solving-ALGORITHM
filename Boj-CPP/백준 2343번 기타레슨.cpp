#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int n,m,answer;
vector<int> v;
int start,finish;
bool possible(int n1)
{
	int cnt(1),sum(0);
	for(int i=0; i<n; i++)
	{
		if(sum+v[i]>n1)
		{
			cnt++;
			sum=v[i];
		}else
		sum+=v[i];
	}
	return cnt<=m;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
		finish+=v[i];	
	}
	start=*max_element(v.begin(),v.end());
	while(start<=finish)
	{
		int mid((start+finish)/2);
		if(possible(mid))
		{
			answer=mid;
			finish=mid-1;
		}else
		start=mid+1;
		
	}
	cout<<answer;
	
	
}
