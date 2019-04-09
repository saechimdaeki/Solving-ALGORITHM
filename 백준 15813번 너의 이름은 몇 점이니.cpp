#include<iostream>
using namespace std;
int sum;
int main()
{
	int n;
	cin>>n;
	string s;
	cin>>s;
	for(int i=0; i<n; i++)
		sum+=s[i]-'A'+1;
		
		cout<<sum<<endl;
}
