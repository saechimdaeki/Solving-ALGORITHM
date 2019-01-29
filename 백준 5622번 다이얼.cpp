#include<iostream>
#include<Cstring>
using namespace std;

int main()
{
	int sum(0);
	string str;
	cin>>str;
	for(int i=0; i<str.length(); i++)
	{
		if(str[i]=='1')
			sum+=2;
			else if(str[i]>=65&&str[i]<=67)
			sum+=3;
			else if(str[i]>=68&&str[i]<=70)
			sum+=4;
			else if(str[i]>=71&&str[i]<=73)
			sum+=5;
			else if(str[i]>=74&&str[i]<=76)
			sum+=6;
			else if(str[i]>=77&&str[i]<=79)
			sum+=7;
			else if(str[i]>=80&&str[i]<=83)
			sum+=8;
			else if(str[i]>=84&&str[i]<=86)
			sum+=9;
			else if(str[i]>=87&&str[i]<=91)
			sum+=10;
			else
			sum+=11;
	}
	cout<<sum;
	
}
