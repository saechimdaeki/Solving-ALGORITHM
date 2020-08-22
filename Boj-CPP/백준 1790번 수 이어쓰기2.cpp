#include<iostream>
#include<algorithm>
using namespace std;
int n,answer;
long long k;

long long solve(int num)
{
	long long ans=0;
	for(int i=1,len=1; i<=num; i*=10,len++)
	{
		int end=i*10-1;
		if(end>num)
		end=num;
		ans+=(end-i+1)*len;
	}
	return ans;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	if(solve(n)<k)
	{
		cout<<-1;
		return 0;
	}
	int left(1),right(n);
	while(left<=right)
	{
		int mid((left+right)/2);
		long long len(solve(mid));
		if(len<k)
		left=mid+1;
		else
		{
			answer=mid;
			right=mid-1;
		}
	}
	string s=to_string(answer);
	long long len=solve(answer);
	cout << s[s.length()-(len-k)-1];	
}
