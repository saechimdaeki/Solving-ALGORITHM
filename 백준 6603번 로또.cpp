#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

vector<int> v;

void bts(vector<int> &a, int index, int cnt)
{
	if(cnt==6)
	{
		for(int num:v)
		cout<<num<<" ";
		cout<<"\n";
		return;
	}
	int n(a.size());
	if(n==index)
	return ;
	v.push_back(a[index]);
	bts(a,index+1,cnt+1);
	v.pop_back();
	bts(a,index+1,cnt);
}
int main()
{
	while(true)
	{
		int n;
		cin>>n;
		if(n==0)
		break;
		vector<int> a(n);
		for(int i=0; i<n; i++)
		cin>>a[i];
		bts(a,0,0);
		cout<<"\n";
	}
	
}
