#include<iostream>
#include<algorithm>
using namespace std;

bool check(string s)
{
	int mo(0),za(0);
	bool ck(false);
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
		{
			mo++;
			ck=true;
			if(mo==3)
			return false;
			za=0;
		}
		else
		{
			za++;
			if(za==3)
			return false;
			mo=0;
		}
		if(s[i]!='o'&&s[i]!='e'&&s[i]==s[i+1])
		return false;
	}
	if(ck==false)
	return false;
	return true;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string password;
	while(1)
	{
		cin>>password;
		if(password=="end")
		return 0;
		cout<<"<"<<password<<"> "<<"is ";
		if(check(password))
		cout<<"acceptable.\n";
		else
		cout<<"not acceptable.\n";
	}
}
