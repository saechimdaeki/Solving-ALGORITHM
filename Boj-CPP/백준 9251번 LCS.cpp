#include<iostream>
#include<algorithm>
using namespace std;
int c[1001][1001];
string s1,s2;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s1>>s2;
	for(int i=1;i<=s1.length();i++) {
		for (int j = 1; j<= s2.length(); j++) {
			if (s1[i - 1] == s2[j - 1]) 
				c[i][j] = c[i - 1][j - 1] + 1;
			else 
				c[i][j] = max(c[i][j - 1], c[i - 1][j]);
			
		}
	}
	cout << c[s1.length()][s2.length()];

}
