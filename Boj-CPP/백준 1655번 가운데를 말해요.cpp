#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<functional>
#define endl '\n'
using namespace std;
int n;
priority_queue<int> leftq;
priority_queue<int, vector<int> , greater<int> > rightq;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	while(n--)
	{
		int x;
		cin>>x;
		if(leftq.empty()|| rightq.empty())
		leftq.push(x);
		else{
			if(x<=leftq.top())
			leftq.push(x);
			else if(x>=rightq.top())
			rightq.push(x);
			else
			leftq.push(x);
		}
		while(!(leftq.size()==rightq.size()||leftq.size()==rightq.size()+1))
		{
			if(leftq.size()>rightq.size())
			{
				rightq.push(leftq.top());
				leftq.pop();
			}else
			{
				leftq.push(rightq.top());
				rightq.pop();
			}
		}
		cout<<leftq.top()<<endl;
	}
}
