#include<iostream>
#include<cstring>
using namespace std;

int main()
{
	char string[100];
	cin>>string;
	int len=strlen(string);
	
	for(int i=0; i<len; i++)
	{
		cout<<string[i];
		if((i+1)%10==0)
		cout<<endl;
	}
	
}
