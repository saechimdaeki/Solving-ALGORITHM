#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int n,m;
vector<string> v;
vector<string> save;
string input;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	for(int i=0; i<m; i++)
	{
		cin>>input;
		if(binary_search(v.begin(),v.end(),input)==1)
		save.push_back(input);
	}
	cout<<save.size()<<"\n";
	sort(save.begin(),save.end());
	for(int i=0; i<save.size(); i++)
	cout<<save[i]<<"\n"; 
}
