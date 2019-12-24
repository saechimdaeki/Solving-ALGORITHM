#include<iostream>
#include<vector>
#define endl '\n'
using namespace std;
int n;
vector<int> v;
int possible(int bts)
{
	int count123(0);
	while(bts!=0)
	{
		if(bts%2==1)
		count123++;
		bts/=2;
		if(count123>1)
		return 123;
	}
	return 0;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<v.size(); i++)
		cin>>v[i];
	for(int i=0; i<v.size(); i++)
	{
		if(possible(v[i]))
		cout<<"Gazua"<<endl;
		else
		cout<<"GoHanGang"<<endl;	
	}	
}
