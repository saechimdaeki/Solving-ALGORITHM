#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;

int n,k,s,y;
int answer;
int v[2][7];//성별2개에 초딩학년6
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin>>n>>k;
	int count123(k-1);
	for(int i=0; i<n; i++)
	{
		cin>>s>>y;
		v[s][y]++;
	}
	for(int i=0; i<2; i++)
	{
		for(int j=0; j<7; j++)
		{
			if(v[i][j])
			answer+=(v[i][j]+count123)/k;
		}
	 } 
	 cout<<answer;
	
}
