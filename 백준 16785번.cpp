#include<iostream>
#define endl '\n'
using namespace std;
int a,b,c,day,cnt,sum;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>c;
	while(1)
	{
		if(sum>=c)
		{
			break;
		}
		if(cnt==7)
		{
			sum+=b;
			if(sum>=c)
			break; 
			cnt=0;
		}
		sum+=a;day++;cnt++;
	}
	cout<<day<<endl;
	
}
