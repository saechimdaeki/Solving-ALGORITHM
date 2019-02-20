#include<iostream>
#include<ctime>
#include<cstdlib>
using namespace std;

int main()
{
	string s;
	cin>>s;
	
	srand(time(NULL));
	int n=rand()%2;
	cout<<n;
}
