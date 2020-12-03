#include<iostream>
#include<algorithm>
using namespace std;
int tmp;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
    int abcd=stoi(s);
	for(int i=5; i<=abcd; i*=5)
	{	
		tmp += abcd/i;
	}	
	cout<<tmp;
    //핸드폰풀이라 틀릴수잇음
}
