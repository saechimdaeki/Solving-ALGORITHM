#include <iostream>
#include<algorithm>
using namespace std;


int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y,x%y);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
    int t;
    cin >> t;
 	for(int z=0; z<t; z++)
       {
		 int a[101];
        int n;
        cin >> n;
        for (int i=0; i<n; i++) {
            cin >> a[i];
        }
        long long sum=0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                sum += gcd(a[i],a[j]);
            }
        }
        cout << sum << '\n';
    }
    return 0;
}
