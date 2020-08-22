#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;
int n;
int ans;
int sum;
vector<int> so; 
int eratos(int num)
{
	if(num==0)
	return 0;
	int bts=(int)sqrt(num);
	for(int i=2; i<=bts; i++)
	{
		if(num%i==0)
		return 0;
	}
	return 1;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=2; i<=n; i++)
	{
		if(eratos(i))
		so.push_back(i);
	}
	int left(0),right(0);
	while(1)
	{
		if(sum>=n)
		{
			sum-=so[left];
			left++;
		}
		else{
			if(right==so.size())
			break;
			sum+=so[right];
			right++;
		}
		if(sum==n)
		ans++;
	}
	cout<<ans;
}
