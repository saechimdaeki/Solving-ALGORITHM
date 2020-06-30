#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;
int n;
class table{
	public:
		int begin,end;
};
	bool cmp(table &a , table &b)
	{
		if(a.end==b.end)
		return a.begin< b.begin;
		else
		return a.end<b.end; 
	}
table table2[100001];
int count123,pointer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>table2[i].begin>>table2[i].end;
	}
	sort(table2,table2+n,cmp);
	for(int i=0; i<n; i++)
	{
		if(pointer<=table2[i].begin)
		{
			pointer=table2[i].end;
			count123++;
		}
	}
	cout<<count123;
}
