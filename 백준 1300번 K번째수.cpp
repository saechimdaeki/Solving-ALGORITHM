#include<iostream>
#include<algorithm>
using namespace std;
long long n,k,answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	long long left(1),right(n*n);
	while(left<=right)
	{
		long long mid((left+right)/2);
		long long cnt(0);
		for(long long i=1; i<=n; i++)
		cnt+=min(n,mid/i);
		if(cnt>=k)
		{
			answer=mid;
			right=mid-1;
		}else
		left=mid+1;
	}
	cout<<answer;
}
