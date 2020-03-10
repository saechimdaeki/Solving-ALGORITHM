#include<iostream>
#include<vector>
#define endl '\n'
using namespace std;
string s,save;
int answer;
bool pluscheck,minuscheck;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	s+="g"; //end char
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='+' || s[i]=='-' ||s[i]=='g' )
		{
			if(minuscheck)
			answer-=stoi(save);
			else
			answer+=stoi(save);
			save="";
			if(s[i]=='-')
			minuscheck=true;
			continue;
		}
		save+=s[i];
	}
	cout<<answer;
}
