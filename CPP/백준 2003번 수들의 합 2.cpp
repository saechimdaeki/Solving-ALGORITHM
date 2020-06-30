#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> v;
int n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	int left(0),right(0),sum(v[0]),answer(0);
	while(left<=right && right<n)
	{
		if(sum<m)
		{
			right++;
			sum+=v[right];
		}
		else if(sum==m)
		{
			answer++;
			right++;
			sum+=v[right];
		}
		else if(sum>m)
		{
			sum-=v[left];
			left++;
			if(left>right &&left<n)
			{
				right=left;
				sum=v[left];
			}
		}
	}
	cout<<answer;
}
