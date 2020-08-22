#include<iostream>
#include<vector>
#define endl '\n'
using namespace std;
int n,answer;
vector<pair<int, int> > v;
void hanoi(int n,int start,int end)
{
	if(n==1)
	v.push_back({start,end});
	else
	{
		hanoi(n-1,start,6-start-end);
		v.push_back({start,end});
		hanoi(n-1,6-start-end,end);
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	hanoi(n,1,3);	
	cout<<v.size()<<endl;
	for(int i=0; i<v.size(); i++)
	cout<<v[i].first<<' '<<v[i].second<<endl;
	
} 
