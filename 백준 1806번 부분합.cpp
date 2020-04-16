#include<iostream>
#include<vector>
using namespace std;
int n,s;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>s;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	int left(0),right(0),sum(v[0]),ans(n+1);
	while(left<=right && right<n)
	{
		if(sum<s)
		{
			right++;
			sum+=v[right];
		}else if(sum==s)
		{
			if(right-left+1<ans)
				ans=right-left+1;
			right++;
			sum+=v[right];
		}else if(sum>s)
		{
			if(right-left+1<ans)
			ans=right-left+1;
			sum-=v[left];
			left++;
		}
	}
	cout<<(ans>n ? 0 : ans);
}
