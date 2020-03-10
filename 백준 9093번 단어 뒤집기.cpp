#include<iostream>
#include<algorithm>
#define endl '\n'
using namespace std;
int t;
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);cin>>t;cin.ignore();
	while(t--)
	{
		string s,p,a;
		getline(cin,s);
		s+='\n';
		for(int i=0; i<=s.length(); i++)
		{
			
			if(s[i]==' '||s[i]=='\n')
			{
				reverse(p.begin(),p.end());
				a+=p;
				a+=" ";
				p="";
			}else{
				p+=s[i];
			}					
		}
		cout<<a<<endl;
	}
	
}
