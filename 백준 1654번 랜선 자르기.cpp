#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
long long n,m;
long long lan[10001];
bool abc=false;
long long answer;

void checkman(long long mid)
{
	int count123(0);
	for(int i=0; i<n; i++)
	count123+=lan[i]/mid;
	if(count123>=m)
	abc=true;
	else
	abc=false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	long long right(0);
	for(int i=0; i<n; i++)
	{
		cin>>lan[i];
		right=max(right,lan[i]);
	}
	long long left(1);
	while(left<=right)
	{
		long long mid=(left+right)/2;
		checkman(mid);
		if(abc==true)
		{
			if(answer<mid)
			answer=mid;
			else
			left=mid+1;
		}
		else
		right=mid-1;
	}
	cout<<answer;
}
