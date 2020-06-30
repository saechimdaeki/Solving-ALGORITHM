#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int t,n,m,cnt;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	while(t--)
	{
		cin>>n>>m;
		if(n<12 || m<4)
		cout<<"-1"<<endl;
		else
		cout<<m*11+4<<endl;
	}
}
