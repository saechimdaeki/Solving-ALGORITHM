#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,c;
vector<int > v;
int answer;
bool possible(int n1)
{
	int cnt(1);
	int last(v[0]);
	for(auto i: v)
	{
		if(i-last>=n1)
		{
			cnt++;
			last=i;
		}
	}
	if(cnt>=c)
	return true;
	return false;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>c;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	auto p=minmax_element(v.begin(),v.end());
	int left(1),right(*p.second-*p.first);
	sort(v.begin(),v.end());
	while(left<=right)
	{
		int mid((left+right)/2);
		if(possible(mid))
		{
			answer=mid;
			left=mid+1;
		}else
			right=mid-1;
	}
	cout<<answer;
}
