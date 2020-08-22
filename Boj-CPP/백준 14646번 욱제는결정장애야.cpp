#include<iostream>
#include<algorithm>
#define endl '\n'
#include<vector>
using namespace std;
int n;
vector<int> v;
vector<int> check;
int checknum,ans;
bool checkbit[100001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(2*n);
	for(int i=0; i<v.size(); i++)
	cin>>v[i];
	
	for(int i=0; i<v.size(); i++)
	{
		if(checkbit[v[i]]==false)
		{
			check.push_back(v[i]);
			checkbit[v[i]]=true;	
		}	
			
		else
		checknum++;
		ans=max(ans,(int)check.size()-checknum);
	}
	cout<<ans;
	
}
