#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
long long n,m,answer;
vector<long long> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	long long left(1),right(*max_element(v.begin(),v.end())*m);
	sort(v.begin(),v.end());
	while(left<=right)
	{
		long long mid((left+right)/2);
		long long sum(0);
		for(int i=0; i<n; i++)
		sum+=mid/v[i];
		if(sum>=m)
		{
			answer=mid;
			right=mid-1;
		}else
		left=mid+1;
	}
	cout<<answer;
}
