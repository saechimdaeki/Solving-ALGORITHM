#include<iostream>
using namespace std;

int main()
{
	int a,b,c;
	
	cin>>a;cin>>b;cin>>c;
	
	cout<<(a+b)%c<<endl;
	cout<<(a%c+b%c)%c<<endl;
	cout<<(a*b)%c<<endl;
	cout<<(a%c*b%c)%c<<endl;
	//ÀúÀå¼Ò rename test 
}
