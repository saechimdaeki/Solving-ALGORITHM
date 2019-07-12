#include<iostream>
#include<algorithm>
using namespace std;

int check(string s)
{
	int mo(0),za(0);
	int bit(0);
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
		{
			mo++;
			bit++;
			if(mo==3)
			return 0;
			za=0;
		}
		else
		{
			za++;
			if(za==3)
			return 0;
			mo=0;
		}
		if(s[i]!='o'&&s[i]!='e'&&s[i]==s[i+1])
		return 0;
	}
	if(bit==0)
	return 0;
	return 1;
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
		goto z;
		cout<<"<"<<password<<"> "<<"is ";
		if(check(password))
		cout<<"acceptable.\n";
		else
		cout<<"not acceptable.\n";
	}
	z:
		return 0;
}
