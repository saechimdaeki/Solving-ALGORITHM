#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;
vector<int> v;
int n,m,answer;
bool possible(int n1)
{
	int ans(1),t1(v[0]),t2(v[0]);
	for(int i=0; i<n; i++)
	{
		t1=min(t1,v[i]);
		t2=max(t2,v[i]);
		if(t2-t1>n1)
		{
			ans++;
			t1=v[i];
			t2=v[i];
		}
	}
	if(ans<=m)
	return true;
	else
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
	int left(0),right(*max_element(v.begin(),v.end()));
	answer=right;
	while(left<=right)
	{
		int mid((left+right)/2);
		if(possible(mid))
		{
			answer=min(mid,answer);
			right=mid-1;
		}else
		left=mid+1;
	}
	cout<<answer;
}
