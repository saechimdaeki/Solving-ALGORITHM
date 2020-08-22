#include<iostream>
using namespace std;
string s;
int solve(string &s1, int idx, char last)
{
	if(s1.length()==idx)
	return 1;
	char start=(s[idx]=='c'?'a':'0');
	char end=(s[idx]=='c'?'z':'9');
	int answer(0);
	for(char i=start; i<=end; i++)
	{
		if(i!=last)
		answer+=solve(s1,idx+1,i);
	}
	return answer;
}
int main()
{
	cin>>s;
	cout<<solve(s,0,',');
}
