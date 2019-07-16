#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
int n,k;
queue<int> q;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	cout<<"<";
	for(int i=1; i<=n; i++)
	q.push(i);
	
	while(!q.empty())
	{
		for(int i=0; i<k-1; i++)
		{
			q.push(q.front());
			q.pop();
		}
		cout<<q.front();
		q.pop();
		if(!q.empty())
		cout<<", ";
	}
	cout<<">";
}
