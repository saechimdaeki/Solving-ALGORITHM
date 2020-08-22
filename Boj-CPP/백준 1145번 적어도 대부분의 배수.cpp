#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int count123;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(5);
	for(int i=0; i<v.size(); i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	int abcd(v[2]);
	while(true)
	{
		for(int i=0; i<v.size(); i++)
		{
			if(abcd%v[i]==0)
			count123++;
		}
		if(count123>2)
		goto z;
		else
		count123=0;
		abcd+=1;
	}
	z:
		cout<<abcd;
}
