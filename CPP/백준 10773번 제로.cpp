#include<iostream>
#include<stack>
#include<algorithm>
using namespace std;
int k,sum;
stack<int> s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>k;
	for(int i=0; i<k; i++)
	{
		int input;
		cin>>input;
		if(input==0)
			s.pop();
		else			
		s.push(input);
	}
	while(!s.empty())
	{
		sum+=s.top();
		s.pop();
	}
	cout<<sum;
}
