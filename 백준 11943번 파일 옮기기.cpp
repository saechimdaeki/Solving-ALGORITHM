#include<iostream>
#include<vector>
using namespace std;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(4);
	for(int i=0; i<4; i++)
	cin>>v[i];
	
	if(v[0]+v[3]>v[1]+v[2])
	cout<<v[1]+v[2];
	else
	cout<<v[0]+v[3];
}
