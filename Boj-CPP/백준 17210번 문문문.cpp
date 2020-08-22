#include <iostream>
#define endl '\n' 
using namespace std;
long long n;
int m;
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	if (n<=5) {
		for (int i = 2; i <= n; i++) {
			m=(m + 1)%2;
			cout<<m<<endl;
		}
	}
	else 
		cout << "Love is open door";

}
