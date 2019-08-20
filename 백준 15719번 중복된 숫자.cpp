#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
int answer;
bool visited[10000001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;cin>>a;
		if(visited[a]==true)
		{
			answer=a;
		}
		visited[a]=true;
		v.push_back(a);
		
	}
	cout<<answer;
}
