#include<iostream>
#include<algorithm>
using namespace std;

int applesum,bananasum;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<3; i++)
	{
		int a;
		cin>>a;
		applesum+=(a)*(3-i);
	 } 
	 for(int i=0; i<3; i++)
	 {
	 	int a;
	 	cin>>a;
	 	bananasum+=(a)*(3-i);
	 }
	if(bananasum>applesum)
	cout<<"B";
	else if(applesum>bananasum)
	cout<<"A";
	else
	cout<<"T";
}
