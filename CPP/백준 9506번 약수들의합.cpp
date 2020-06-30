#include<iostream>
#define endl '\n'
using namespace std;
int n,cnt;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	while(cin>>n)
	{
		cnt=0;
		if(n==-1)
		break;
		for(int i=1; i<n; i++)
		{
			if(n%i==0)
			cnt+=i;
		}
		if(cnt==n)
		{
			cout<<n<<" = 1 ";
			for(int i=2; i<n; i++)
			{
				if(n%i==0)
				cout<<"+ "<<i<<' ';
				
			}
			cout<<endl;
		}else{
			cout<<n<<" is NOT perfect."<<endl;
		}
	}
}
