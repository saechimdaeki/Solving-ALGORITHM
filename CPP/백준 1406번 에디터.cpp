#include<iostream>
#include<stack>
using namespace std;

stack<char> left1;
stack<char> right1;

int main()
{
	string s;
	cin>>s;
	for(int i=0; i<s.length(); i++)
	left1.push(s[i]);
	
	
	int n;
	cin>>n;
	for(int i=0; i<n; i++)
		{
			char a;
			cin>>a;
			switch(a)
			{
				case 'L':
					if(!left1.empty())
					{
						right1.push(left1.top());
						left1.pop();
					}
					break;
				case 'D':
					if(!right1.empty())
					{
						left1.push(right1.top());
						right1.pop();
					}
					break;
				case 'B':
					if(!left1.empty())
						left1.pop();
					break;
				case 'P':
					char b;
					cin>>b;
					left1.push(b);
					break;
						
				
			}
		}
		while(!left1.empty())
		{
			right1.push(left1.top());
			left1.pop();
		}
		string output;
		while(!right1.empty())
		{
			output +=right1.top();
			right1.pop();
		}
		cout<<output<<endl;
}
