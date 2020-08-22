#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> s;
bool check[100001*20];
void solution(int idx,int sum)
{
	if(idx==n)
	{
		check[sum]=true;
		return;
	}
	solution(idx+1,sum+s[idx]);
	solution(idx+1,sum);
	
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	s.resize(n);
	for(int i=0; i<n; i++)
	cin>>s[i];
	solution(0,0);
	for(int i=1;i<100001*20 ; i++)
	{
		if(!check[i])
		{
			cout<<i;
			break;
		}
	}
}
