#include<iostream>
#include<deque>
using namespace std;
deque<int> dq;
int n,x;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>s;
		if(s=="push_front")
		{
			cin>>x;
			dq.push_front(x);
		}
		else if(s=="push_back")
		{
			cin>>x;
			dq.push_back(x);
		}
		else if(s=="pop_front")
		{
			if(dq.empty())
			cout<<"-1\n";
			else
			{
				cout<<dq.front()<<"\n";
				dq.pop_front();
			}
		}
		else if(s=="pop_back")
		{
			if(dq.empty())
			cout<<"-1\n";
			else
			{
				cout<<dq.back()<<"\n";
				dq.pop_back();
			}
		}
		else if(s=="size")
		{
			cout<<dq.size()<<"\n";
		}
		else if(s=="front")
		{
			if(dq.empty())
			cout<<"-1\n";
			else
			cout<<dq.front()<<"\n";
		}
		else if(s=="back")
		{
			if(dq.empty())
				cout<<"-1\n";
			else
				cout<<dq.back()<<"\n";	
		}
		else if(s=="empty")
		{
			if(dq.empty())
			cout<<"1\n";
			else
			cout<<"0\n";
		}
	}
}
