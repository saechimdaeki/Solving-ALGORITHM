#include<iostream>
#include<queue>
#define endl '\n'
using namespace std;
int n;
priority_queue<int> pq;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	while(n--)
	{
		int x;
		cin>>x;
		if(x==0)
		{
			if(pq.empty())
			cout<<"0"<<endl;
			else
			{
				cout<<pq.top()<<endl;
				pq.pop();
			}
		}else
		pq.push(x);
	}
}
