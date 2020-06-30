#include<iostream>
#include <vector>
#include<stack>
using namespace std;

int main()
{
	int n;
	cin>>n;
	stack<int> s;
	vector<char> res(2*n);
	int next=1;
	int count(0);
	
	for(int i=0; i<n; i++)
	{
		int abc;
		cin>>abc;
		while(s.empty()||abc!=s.top())
		{
			if(next>n)
			{
				cout<<"NO\n";
				return 0;
			}
			s.push(next++);
			res[count++]='+';
		}
		s.pop();
		res[count++]='-';
	}
	for(int i=0; i<res.size(); i++)
	cout<<res[i]<<"\n";
}
