#include<iostream>
#include<algorithm>
#define endl '\n'
using namespace std;
bool tag;
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
		int open(0),close(0);
		string s,temp,answer;
		getline(cin,s);
		for(int i=0; i<s.length(); i++)
		{
			if(s[i]=='<')
			{
				reverse(temp.begin(),temp.end());
				cout<<temp;
				temp="";
				tag=true;
				cout<<s[i];	
			}else if(s[i]=='>'){
				tag=false;
				cout<<s[i];
			}else if(tag){
				cout<<s[i];
			}else{
				if(s[i]==' '){
					reverse(temp.begin(),temp.end());
					cout<<temp;
					temp="";
					cout<<s[i];
				}else{
					temp+=s[i];
				}
			}					
		}
		reverse(temp.begin(),temp.end());
		cout<<temp;
		cout<<endl;
	
	
}
